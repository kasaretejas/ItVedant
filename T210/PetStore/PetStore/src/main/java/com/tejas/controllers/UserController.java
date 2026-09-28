package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.daos.UserLogin;
import com.tejas.daos.UserRegister;
import com.tejas.jwt.JWTTokenGenerator;
import com.tejas.services.MyUserDetailsService;
import com.tejas.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController 
{
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserRegister userRegister)
	{
		return userService.register(userRegister);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLogin userLogin)
	{
		return userService.login(userLogin);
	}
	
	
	
}
