package com.tejas.models;

import org.hibernate.annotations.Collate;

import com.tejas.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String fullName;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private String pincode;
	
	@Enumerated(EnumType.STRING)
	private Role role;

}
