package com.tejas.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//constraints for SQL
	@Column(nullable = false, unique = true) 
	//validations for spring. Note: use @Valid in controller with post mapping
	@Size(min=3, max = 15, message = "only 3 to 15 characters allowed for category")
	private String name;

	@OneToMany(mappedBy = "category")
	private List<SubCategory> subCategories;
	
}















