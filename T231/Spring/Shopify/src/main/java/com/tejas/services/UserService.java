package com.tejas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tejas.dtos.UserDTO;
import com.tejas.entities.Customer;
import com.tejas.entities.User;
import com.tejas.entities.Vendor;
import com.tejas.jwt.JWTTokenGenerator;
import com.tejas.repositories.CustomerRepository;
import com.tejas.repositories.UserRepository;
import com.tejas.repositories.VendorRepository;
import com.tejas.response_wrapper.CustomResponse;
import com.tejas.response_wrapper.JWTResponseWrapper;
import com.tejas.response_wrapper.Response;

@Service
public class UserService 
{
	@Autowired
	Response response;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	VendorRepository vendorRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public ResponseEntity<CustomResponse>  register(User user)
	{
		if(userRepository.existsByUsername(user.getUsername()))
		{
			return response.send("Username already exists", null, HttpStatus.FOUND);
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User savedUser=userRepository.save(user);
		
		String role=user.getRole().name();
		if(role.equals("CUSTOMER"))
		{
			Customer customer = new Customer();
			customer.setUser(savedUser); //adding FK of user into customer
			Customer savedCustomer=customerRepository.save(customer);
			return response.send("Customer Registered", savedCustomer, HttpStatus.OK);
			
		}
		else
		{
			Vendor vendor = new Vendor();
			vendor.setUser(savedUser); //adding FK of user into vendor
			Vendor savedVendor=vendorRepository.save(vendor);
			return response.send("Vendor Registered", savedVendor, HttpStatus.OK);
		}
		
		
	}
	
	//login
	@Autowired
	JWTResponseWrapper jwtResponseWrapper;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTTokenGenerator jwtTokenGenerator;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	
	public ResponseEntity<CustomResponse>  login(UserDTO userDTO)
	{
		try 
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
		}
		catch (AuthenticationException e) 
		{
			return response.send("Bad Credentials", null, HttpStatus.NOT_FOUND);
		}
		//to send response after login, we required 3 things - jwt token , role, logged in user id (based on their role)
		//1. generating JWT token
		User existingUser=userRepository.findByUsername(userDTO.getUsername()).get();
		String role = existingUser.getRole().name(); //for generating jwt token
		UserDetails userDetails=myUserDetailsService.loadUserByUsername(userDTO.getUsername()); //for generating jwt token
		final String JWTtoken=jwtTokenGenerator.generateToken(userDetails, role);//jwt token generated
		
		//2. getting user id based on their role (if user is CUSTOMER then get customer id etc)
		long id;
		if(role.equals("VENDOR"))
		{
			Vendor existingVendor=vendorRepository.findByUserId(existingUser.getId()).get();
			id=existingVendor.getId();
		}
		else
		{
			Customer existingCustomer=customerRepository.findByUserId(existingUser.getId()).get();
			id=existingCustomer.getId();
		}
		
		
		jwtResponseWrapper.setId(id);
		jwtResponseWrapper.setRole(role);
		jwtResponseWrapper.setJwtToken(JWTtoken);
		
		return response.send("Login Success!", jwtResponseWrapper, HttpStatus.OK);
		
		
	}
}











