package com.tejas.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tejas.jwt.JWTRequestValidator;
import com.tejas.jwt.JWTTokenGenerator;
import com.tejas.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JWTTokenGenerator jwtTokenGenerator;
	
	@Autowired
	private JWTRequestValidator jwtRequestValidator;
	
	@Bean
	PasswordEncoder myPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		 httpSecurity
				.csrf(anyRequest -> anyRequest.disable())  // disable CSRF
				.authorizeHttpRequests(request -> request
					.requestMatchers("/api/v1/login", "/api/v1/register").permitAll()
					//.requestMatchers("/api/v1/admin/**").hasAuthority("ADMIN")
				    //.requestMatchers("/api/v1/customer/**").hasAuthority("CUSTOMER")
					.anyRequest().authenticated())
				.sessionManagement(session -> session
			            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			        );
		httpSecurity.addFilterBefore(jwtRequestValidator, UsernamePasswordAuthenticationFilter.class);
		return		httpSecurity.build();
	}
	
	
}
