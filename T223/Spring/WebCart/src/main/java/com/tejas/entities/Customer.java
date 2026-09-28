package com.tejas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String fullname;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String pincode;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

}
