package com.tejas.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UnivesalResponse 
{
	@Autowired
	WebResponseWrapper responseWrapper;
	
	public ResponseEntity<?> send(String message, Object data, HttpStatus httpStatus)
	{
		responseWrapper.setMessage(message);
		responseWrapper.setData(data);
		return new ResponseEntity<>(responseWrapper, httpStatus);
	}
}
