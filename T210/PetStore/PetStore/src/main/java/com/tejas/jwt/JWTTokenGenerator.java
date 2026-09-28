package com.tejas.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JWTTokenGenerator 
{
	private final String SECRET  = "F!7v2u9Q@3eR#8sXzL1pT6kWqY%mB^4h";
	 
	// Extract EMAIL from JWT
	 public String extractEmail(String token) {
	        Claims claims = extractAllClaims(token);
	        return claims.get("email", String.class);
	    }
	 
	  // Extract ROLE from JWT
	 public String extractRole(String token) {
	        Claims claims = extractAllClaims(token);
	        return claims.get("role", String.class);
	    }
	 
	 // Extract all claims
	 private Claims extractAllClaims(String token) {
	        return Jwts.parser()
	                .setSigningKey(SECRET)
	                .parseClaimsJws(token)
	                .getBody();
	    }
	 
	  // Check if token expired
	 private Boolean isExpired(String token) {
	        Claims claims = extractAllClaims(token);
	        Date expiration = claims.getExpiration();
	        return expiration.before(new Date());
	    }
	 
	// Validate token
	 public Boolean validateToken(String token, UserDetails userDetails) {
	        String email = extractEmail(token);
	        return (email.equals(userDetails.getUsername()) && !isExpired(token));
	    }
	 
	 
	 public String generateToken(UserDetails userDetails, String role) {

	        Map<String, Object> claims = new HashMap<>();
	        claims.put("email", userDetails.getUsername());  // username = email
	        claims.put("role", role);

	        return Jwts.builder()
	                .setClaims(claims)
	                .setSubject(userDetails.getUsername())  // optional
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hrs
	                .signWith(SignatureAlgorithm.HS256, SECRET.getBytes())
	                .compact();
	    }
	}