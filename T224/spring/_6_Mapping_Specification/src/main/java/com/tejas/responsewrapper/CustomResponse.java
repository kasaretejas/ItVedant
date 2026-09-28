package com.tejas.responsewrapper;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class CustomResponse {
	private String message;
	private Object data;

}
