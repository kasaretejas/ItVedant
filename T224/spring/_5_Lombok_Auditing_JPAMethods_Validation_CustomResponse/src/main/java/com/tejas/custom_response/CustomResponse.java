package com.tejas.custom_response;

import org.springframework.stereotype.Component;

import com.tejas.entities.Pet;

import lombok.Data;

@Component
@Data
public class CustomResponse {
	private String message;
	private Object data;

}
