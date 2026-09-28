package com.tejas.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double price;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="subcategory_id")
	private SubCategory subCategory;
	
	@ManyToOne
	@JoinColumn(name="vendor_id")
	private Vendor vendor;
	
	@OneToMany(mappedBy =  "product")
	private List<Cart> carts;
}
