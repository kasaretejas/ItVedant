package com.tejas.jwt;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tejas.services.MyUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTRequestValidator extends OncePerRequestFilter {
	
	@Autowired
	JWTTokenGenerator jwtTokenGenerator;
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain filterChain)throws ServletException, IOException //import java.io.IOException; 
	{
		final String header = request.getHeader("Authorization");
		String jwtToken = null;
		String username = null;
		String role = null;
		 // Extract token
		 if (header != null && header.startsWith("Bearer "))
		 {
			 jwtToken = header.substring(7);
			 try
			 {
				 username = jwtTokenGenerator.extractUsername(jwtToken);
				 role = jwtTokenGenerator.extractRole(jwtToken);
			 }
			 catch (Exception e)
			 {
				 System.out.println("Invalid Token: " + e.getMessage());
			 }
		}
		 // Authenticate user if token is valid
		 if (username != null && SecurityContextHolder.getContext().getAuthentication() ==null)
		 {
			 UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
			 if (jwtTokenGenerator.validateToken(jwtToken, userDetails))
			 {
				 List<SimpleGrantedAuthority> authorities =List.of(new SimpleGrantedAuthority(role));
			
				 System.out.println("ROLE FROM TOKEN = " + role);
				 System.out.println("AUTHORITIES SET = " + authorities);
				 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						 																				null,
						 																				authorities);
				 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 SecurityContextHolder.getContext().setAuthentication(authToken);
		    }
	     }
	 filterChain.doFilter(request, response);
	}


}
