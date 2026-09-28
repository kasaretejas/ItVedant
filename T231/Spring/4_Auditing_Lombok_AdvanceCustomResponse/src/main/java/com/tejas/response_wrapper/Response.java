package com.tejas.response_wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tejas.entities.Student;

@Component
public class Response {
	
	@Autowired
	CustomRepsonse customRepsonse;
	
	public ResponseEntity<CustomRepsonse> send(String message, Object data, HttpStatus httpStatus)
	{
		customRepsonse.setMessage(message);
		customRepsonse.setData(data);
		return new ResponseEntity<CustomRepsonse>(customRepsonse, httpStatus);
	}

}
