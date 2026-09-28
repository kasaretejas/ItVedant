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

import com.tejas.custom_response.JWTResponse;
import com.tejas.custom_response.Response;
import com.tejas.dtos.UserLoginDTO;
import com.tejas.entities.Customer;
import com.tejas.entities.User;
import com.tejas.entities.Vendor;
import com.tejas.jwt.JWTTokenGenerator;
import com.tejas.repositories.CustomerRepository;
import com.tejas.repositories.UserRepository;
import com.tejas.repositories.VendorRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	VendorRepository vendorRepository;
	@Autowired
	Response response;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public ResponseEntity<?> register(User user)
	{
		if(userRepository.existsByUsername(user.getUsername()))
		{
			return response.send("Username already exists!", null, HttpStatus.FOUND);
		}
		//encoding password
		String encodedPassword=passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		//saving user data 
		User savedUser=userRepository.save(user); //id, username, encoded password, role
		//adding user id into customer or vendor table according to role
		if(user.getRole().name().equals("CUSTOMER"))
		{
			Customer customer = new Customer();
			customer.setUser(savedUser);//id from savedUser will be added into user_id column of customer table	
			Customer savedCustomer=customerRepository.save(customer);
			return response.send("User Registered as a customer", savedCustomer, HttpStatus.OK);
		}
		else
		{
			Vendor vendor = new Vendor();
			vendor.setUser(savedUser);//id from savedUser will be added into user_id column	of vendor table	
			Vendor savedVendor=vendorRepository.save(vendor);
			return response.send("User Registered as a vendor", savedVendor, HttpStatus.OK);
		}
		
	}
		

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JWTTokenGenerator jwtTokenGenerator;
	@Autowired 
	MyUserDetailsService myUserDetailsService;
	@Autowired
	JWTResponse jwtResponse;
	
	public ResponseEntity<?> login(UserLoginDTO userLoginDTO)
	{
		try
		{
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userLoginDTO.getUsername(), userLoginDTO.getPassword()));
		}
		catch(AuthenticationException e)
		{
			return response.send("bad credentials!", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//genrate JWT TOKEN
		UserDetails userDetails=myUserDetailsService.loadUserByUsername(userLoginDTO.getUsername());
		User existingUser=userRepository.findByUsername(userLoginDTO.getUsername()).get();
		String jwtToken=jwtTokenGenerator.generateToken(userDetails, existingUser.getRole().name());
		//new code 08/sep/2026
		String role = existingUser.getRole().name();
		if(role.equals("VENDOR"))
		{
			//vendorRepository.findByUserId(existingUser.getId()).get() ---> yahan tak hume vendor object mila, user id ke basis par
			//vendorRepository.findByUserId(existingUser.getId()).get().getId() --> vendor object se, vendor ka id mila
			jwtResponse.setId(vendorRepository.findByUserId(existingUser.getId()).get().getId());
		}
		else
		{
			jwtResponse.setId(customerRepository.findByUserId(existingUser.getId()).get().getId());
		}
		
		//jwtResponse.setId(existingUser.getId());
		jwtResponse.setUsername(existingUser.getUsername());
		jwtResponse.setRole(existingUser.getRole().name());
		jwtResponse.setJwtToken(jwtToken);
		
		return response.send("Login success", jwtResponse, HttpStatus.OK);
	}
}









