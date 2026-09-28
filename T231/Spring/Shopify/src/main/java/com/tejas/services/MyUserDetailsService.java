package com.tejas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tejas.entities.User;
import com.tejas.repositories.UserRepository;
//to generate jwt token, we required object of  UserDetails class
//so object of UserDetails class is given by loadUserByUsername method which is abstract method present inside UserDetailsService interface 
//so we need to implement UserDetailsService interface by some class. therefore we have created MyUserDetailsService
@Service
public class MyUserDetailsService implements UserDetailsService
{
	//in order to load user by username, we have to create JPA methdo findByUserName() inside UserRepository
	//and then inject that UserRepository over here
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User existingUser=userRepository.findByUsername(username).get();
		List<SimpleGrantedAuthority> roles = List.of(new SimpleGrantedAuthority(existingUser.getRole().name()));
		return new org.springframework.security.core.userdetails.User(existingUser.getUsername(), existingUser.getPassword(), roles);
	}

}
