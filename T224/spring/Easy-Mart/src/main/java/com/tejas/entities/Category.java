package com.tejas.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

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
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true)
	@Size(min = 3, max = 20, message = "Category must be 3-20 characters")
	private String name;
	
	@OneToMany(mappedBy = "category")
	@JsonIgnoreProperties("category")
	private List<SubCategory> subCategories;
}









