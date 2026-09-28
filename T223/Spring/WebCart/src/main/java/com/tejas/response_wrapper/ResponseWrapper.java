package com.tejas.response_wrapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseWrapper {
	private String message;
	private Object data;
}
