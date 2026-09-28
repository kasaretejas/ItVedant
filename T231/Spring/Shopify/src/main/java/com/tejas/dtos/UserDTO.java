package com.tejas.dtos;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
	@Column(nullable = false) 
	@Size(min=3, max = 10, message = "only 3 to 10 characters allowed for username")
	private String username;
	
	@Column(nullable = false) 
	private String password;
}
