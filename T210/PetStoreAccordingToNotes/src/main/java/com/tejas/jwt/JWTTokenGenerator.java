package com.tejas.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTTokenGenerator 
{
	private final String SECRET  = "GDF7acJj3fHj48U4/rtgWkSb31XKkqv0cHpP9yJJ2kU=";
	 
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
	        return Jwts.parserBuilder()
	                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
	                .build()
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
		 System.out.println(role);
	        Map<String, Object> claims = new HashMap<>();
	        claims.put("email", userDetails.getUsername());  // username = email
	        claims.put("role", role);

	        return Jwts.builder()
	                .setClaims(claims)
	                .setSubject(userDetails.getUsername())  // optional
	                .setIssuedAt(new Date()) // below calculation is for 10 hrs
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
	                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
	                .compact();
	    }
	}
