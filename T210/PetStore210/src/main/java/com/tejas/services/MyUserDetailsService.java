package com.tejas.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tejas.models.User;
import com.tejas.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
    private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(email) //here User is our model/entity
        .orElseThrow(() -> 
             new UsernameNotFoundException("Email not found: " + email)
        );
		
		List<SimpleGrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority(user.getRole().name()));
		
		 return new org.springframework.security.core.userdetails.User(
	                user.getEmail(),
	                user.getPassword(),
	                authorities
	        );
	}
	
	
}
