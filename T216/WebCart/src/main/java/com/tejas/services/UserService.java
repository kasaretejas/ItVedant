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

import com.tejas.doas.UserLogin;
import com.tejas.entities.Customer;
import com.tejas.entities.User;
import com.tejas.entities.Vendor;
import com.tejas.jwt.JWTTokenGenerator;
import com.tejas.repositories.CustomerRepository;
import com.tejas.repositories.UserRepository;
import com.tejas.repositories.VendorRepository;
import com.tejas.response.JwtResponseWrapper;
import com.tejas.response.UnivesalResponse;

@Service
public class UserService {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UnivesalResponse response;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	
	public ResponseEntity<?> register(User user)
	{
		if(userRepository.existsByEmail(user.getEmail()))
		{
			return response.send("Email already exists", null, HttpStatus.FOUND);

		}
	
		String role=user.getRole().name();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User registeredUser=userRepository.save(user);
		if(role.equals("VENDOR"))
		{
			Vendor vendor = new Vendor();
			vendor.setUser(registeredUser);
			vendorRepository.save(vendor);
		}
		else
		{
			Customer customer = new Customer();
			customer.setUser(registeredUser);
			customerRepository.save(customer);
		}
		
		return response.send("User registration success", registeredUser, HttpStatus.OK);
	}

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTTokenGenerator jwtTokenGenerator;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	public ResponseEntity<?> login(UserLogin userLogin)
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
																	userLogin.getEmail(),
																	userLogin.getPassword()));
		 }
		catch (BadCredentialsException e)
		{
			return response.send("Incorrect Username or password", null, HttpStatus.BAD_REQUEST);
		}
		User user =userRepository.findByEmail(userLogin.getEmail()).get();
		UserDetails userDetails =myUserDetailsService.loadUserByUsername(userLogin.getEmail());
		String jwtToken =jwtTokenGenerator.generateToken(userDetails,user.getRole().toString());
		JwtResponseWrapper jwtResponseWrapper = new JwtResponseWrapper();
		jwtResponseWrapper.setToken(jwtToken);
		jwtResponseWrapper.setRole(user.getRole().name());
		jwtResponseWrapper.setUserId(user.getId());
		return response.send("Login Success", jwtResponseWrapper, HttpStatus.OK);
	}

}
