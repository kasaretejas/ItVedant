package com.tejas.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class WebResponseWrapper 
{
	private String message;
	private Object data;
}



