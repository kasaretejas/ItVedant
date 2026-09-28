package com.tejas.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class SubCategory 
{
	@Id
	private long id;
	@Column(nullable = false)
	
	@Size(min=3, max=10, message="category name must be between 3 to 10 characters")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	//@JsonIgnore
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonIgnoreProperties("subCategories")
	private Category category;
}














