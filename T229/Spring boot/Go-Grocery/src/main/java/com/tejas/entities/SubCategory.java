package com.tejas.entities;

import org.hibernate.annotations.Collate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class SubCategory 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Category category;
}
