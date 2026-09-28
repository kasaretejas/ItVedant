package com.tejas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tejas.dto.UserLogin;
import com.tejas.entities.Customer;
import com.tejas.entities.User;
import com.tejas.entities.Vendor;
import com.tejas.jwt.JWTTokenGenerator;
import com.tejas.repositories.CustomerRepository;
import com.tejas.repositories.UserRepository;
import com.tejas.repositories.VendorRepository;
import com.tejas.response_wrapper.JWTResponseWrapper;
import com.tejas.response_wrapper.UnivarsalResponse;

@Service
public class UserService {
	@Autowired
	UnivarsalResponse response;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public ResponseEntity<?> register(User user)
	{
		if(userRepository.existsByUserName(user.getUserName()))
		{
			return response.send("This username already exists", null, HttpStatus.FOUND);
		}
		else
		{
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User savedUser=userRepository.save(user);
			if(user.getRole().name().equals("CUSTOMER"))
			{
				Customer customer = new Customer();
				customer.setUser(savedUser);
				customerRepository.save(customer);
			}
			else
			{
				Vendor vendor = new Vendor();
				vendor.setUser(savedUser);
				vendorRepository.save(vendor);
			}
			return response.send("registration success", savedUser, HttpStatus.OK);
			
		}
	}
	
	
	//login functionality
	@Autowired
	AuthenticationManager authenticationManager; //to authenticate username and password
	
	@Autowired
	MyUserDetailsService myUserDetailsService; //to get UserDeails object 
	
	@Autowired
	JWTTokenGenerator jwtTokenGenerator; //to generate jwt token
	
	@Autowired
	JWTResponseWrapper jwtResponseWrapper; //to send user id, role and jwt token in response 
	
	
	public ResponseEntity<?> login(UserLogin userLogin)
	{
		try
		{
			authenticationManager.authenticate(new 
					UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPassword()));
		}
		catch (BadCredentialsException e) 
		{
			return response.send("Bad Credentials", null, HttpStatus.NOT_FOUND);
		}
		
		//for generating jwt token we required 2 things : 
		//1. Object of UserDetails class - we well get this object when we call loadUserByUsername() of MyUserDetailsService class
		//2. role
		
		UserDetails userDetails=myUserDetailsService.loadUserByUsername(userLogin.getUserName());
		User existingUser=userRepository.findByUserName(userLogin.getUserName()).get();
		String role = existingUser.getRole().name();
		
		String jwtToken=jwtTokenGenerator.generateToken(userDetails, role);
		//---------------------------------------------------------------------
		//jwtResponseWrapper.setId(existingUser.getId());
		//setting id wrt type of user
		if(role.equals("VENDOR")) jwtResponseWrapper.setId(existingUser.getVendor().getId());
		else jwtResponseWrapper.setId(existingUser.getCustomer().getId());
		//------------------------------------------------------------------------
					
		jwtResponseWrapper.setRole(role);
		jwtResponseWrapper.setToken(jwtToken);
		return response.send("Login Success", jwtResponseWrapper, HttpStatus.OK);
		
		
		
	}

}















