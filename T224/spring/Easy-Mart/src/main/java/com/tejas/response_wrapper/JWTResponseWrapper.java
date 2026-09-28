package com.tejas.response_wrapper;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class JWTResponseWrapper
{
	private long id;
	private String token;
	private String role;
}
