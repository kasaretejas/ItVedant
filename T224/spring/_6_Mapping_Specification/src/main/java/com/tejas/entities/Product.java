package com.tejas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name="subcategory_id")
	private SubCategory subCategory;
	
	@ManyToOne
	@JoinColumn(name="vendor_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Vendor vendor;

}
