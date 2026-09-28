package com.tejas.response_wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UnivarsalResponse {

	@Autowired 
	CustomReponse customReponse;
	
	public ResponseEntity<CustomReponse> send(String message, Object data, HttpStatus httpStatus)
	{
		customReponse.setMessage(message);
		customReponse.setData(data);
		return new ResponseEntity(customReponse, httpStatus);
	}

}
