package com.tejas.response_wrapper;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class CustomRepsonse {
	private String message;
	private Object data;

}
