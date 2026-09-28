package com.tejas.response_wrapper;

import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class JwtResponseWrapper
{
	private String token;
	 private String role;
	 private long userId;
}
