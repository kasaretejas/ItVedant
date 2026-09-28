package com.tejas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //to create table
public class Student  //here student (s is small) named table will be created
{
	@Id //to make given field as PK
	@GeneratedValue(strategy = GenerationType.AUTO) //for auto inc
	private long id; 
	
	@Column(nullable = false)
	private String fullName;  //dont write full_name
	
	private String department;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
		
}
