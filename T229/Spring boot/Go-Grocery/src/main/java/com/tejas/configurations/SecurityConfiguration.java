package com.tejas.configurations;

import java.util.List;

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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.tejas.jwt.JWTTokenGenerator;
import com.tejas.jwt.JWTTokenValidator;
import com.tejas.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private JWTTokenValidator jwtTokenValidator;
	
	@Bean
	PasswordEncoder myPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
	{
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity
			.cors(cors-> cors.configurationSource(corsConfigurationSource()))
			.csrf(anyRequest -> anyRequest.disable()) // disable CSRF
			.authorizeHttpRequests(request -> request
			.requestMatchers("/api/v1/register").permitAll()
			.requestMatchers("/api/v1/login").permitAll()
			.requestMatchers("/api/v1/get/**").permitAll()
			.requestMatchers("/api/v1/images/**").permitAll()
			.requestMatchers("/api/v1/vendor/**").hasAuthority("VENDOR")
			.requestMatchers("/api/v1/admin/**").hasAuthority("ADMIN")
			.requestMatchers("/api/v1/customer/**").hasAuthority("CUSTOMER")
			.anyRequest().authenticated())
			.sessionManagement(session -> session
			 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			 );
			httpSecurity.addFilterBefore(jwtTokenValidator,UsernamePasswordAuthenticationFilter.class);
			return httpSecurity.build();
	}
	
	//below must be imported as -
	//import org.springframework.web.cors.CorsConfiguration; NOT FROM REACTIVE
	//import org.springframework.web.cors.CorsConfigurationSource;
	//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
	@Bean
	public CorsConfigurationSource corsConfigurationSource()  //import org.springframework.web.cors.CorsConfigurationSource;
	{
		 CorsConfiguration config = new CorsConfiguration(); //import org.springframework.web.cors.CorsConfiguration;
		 config.setAllowedOrigins(List.of("http://localhost:5173")); // React app
		 config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH","OPTIONS"));
		 config.setAllowedHeaders(List.of("*")); // allow Authorization header
		 config.setExposedHeaders(List.of("*"));
		 config.setAllowCredentials(true);
		 UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); //import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
		 source.registerCorsConfiguration("/**", config);
		 return source;
	}

}
