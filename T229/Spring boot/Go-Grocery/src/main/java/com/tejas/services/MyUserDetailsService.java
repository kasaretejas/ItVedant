package com.tejas.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tejas.entities.User;
import com.tejas.repositories.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User existingUser=userRepository.findByUsername(username).get();
		List<SimpleGrantedAuthority> roles = List.of(new SimpleGrantedAuthority(existingUser.getRole().name()));
		
		return new org.springframework.security.core.userdetails.User(
					existingUser.getUsername(),
					existingUser.getPassword(),
					roles
				);		
	}
}


