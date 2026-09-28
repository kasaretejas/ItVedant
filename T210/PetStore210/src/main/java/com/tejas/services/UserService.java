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

import com.tejas.daos.UserLogin;
import com.tejas.daos.UserRegister;
import com.tejas.jwt.JWTTokenGenerator;
import com.tejas.models.User;
import com.tejas.repositories.UserRepository;
import com.tejas.responsewrapper.JwtResponseWrapper;
import com.tejas.responsewrapper.MyResponseWrapper;

@Service
public class UserService {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	MyResponseWrapper responseWrapper;
	
	@Autowired
	UserRepository userRepository;
	private ResponseEntity<?> universalResponse(String message, Object data, HttpStatus httpStatus)
	{
		responseWrapper.setMessage(message);
		responseWrapper.setData(data);
		return new ResponseEntity<> (responseWrapper,httpStatus);
	}
	
	
	public ResponseEntity<?> register(UserRegister userRegister)
	{
		if(userRepository.existsByEmail(userRegister.getEmail()))
		{
			return universalResponse("Email Exists",null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		User newUser = new User();
		newUser.setEmail(userRegister.getEmail());
		newUser.setPassword(passwordEncoder.encode(userRegister.getPassword()));
		newUser.setRole(userRegister.getRole());
		User registeredUser=userRepository.save(newUser);
		return universalResponse("Registration Success!",registeredUser, HttpStatus.CREATED);
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
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword())
            );
        } 
		catch (BadCredentialsException e) 
		{
			return universalResponse("Incorrect Username or password",null, HttpStatus.BAD_REQUEST);
        }
		
		User user =userRepository.findByEmail(userLogin.getEmail()).get();
		UserDetails userDetails = myUserDetailsService.loadUserByUsername(userLogin.getEmail());
		String jwtToken =jwtTokenGenerator.generateToken(userDetails, user.getRole().toString());
		
		JwtResponseWrapper jwtResponseWrapper = new JwtResponseWrapper();
		jwtResponseWrapper.setToken(jwtToken);
		jwtResponseWrapper.setRole(user.getRole().name());
		jwtResponseWrapper.setUserId(user.getId());
		return universalResponse("Login Success",jwtResponseWrapper, HttpStatus.OK);
	}
	

}
