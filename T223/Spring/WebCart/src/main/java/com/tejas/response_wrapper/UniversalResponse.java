package com.tejas.response_wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UniversalResponse {
	@Autowired
	ResponseWrapper responseWrapper;
	
	public ResponseEntity<ResponseWrapper> send(String message, Object data, HttpStatus httpStatus)
	{
		responseWrapper.setMessage(message);
		responseWrapper.setData(data);
		return new ResponseEntity<ResponseWrapper>(responseWrapper,httpStatus);
	}

}
