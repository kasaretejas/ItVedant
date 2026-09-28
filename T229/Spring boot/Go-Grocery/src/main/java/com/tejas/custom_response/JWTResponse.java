package com.tejas.custom_response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class JWTResponse {

	private long id;
	private String username;
	private String role;
	private String jwtToken;
}
