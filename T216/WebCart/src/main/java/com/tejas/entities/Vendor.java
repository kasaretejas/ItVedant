package com.tejas.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	//@Column(nullable = false, unique = true)
	private String companyName;
	
	//@Column(nullable = false, unique = true)
	private String registrationId;
	
	//@Column(nullable = false, unique = true)
	private String phone;
	
	@OneToMany(mappedBy = "vendor")
	@JsonIgnore
	private List<Product> products;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
}
