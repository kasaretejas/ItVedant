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
	
	@Column(nullable = false, unique = true)  //constraints
	@Size(min = 3, max = 15, message = "category name must be between 3 to 15 characters") //validations
	private String name;

	//@Min, @Max, @Pattern, @Email....do search more spring boot validation annotations
	
	@OneToMany(mappedBy = "category")
	private List<SubCategory> subCategories;
}


