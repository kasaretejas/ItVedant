package com.tejas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //it will create table with name same as class name. ex: Employee--->employee
public class Employee 
{
	@Id //it will make id as a PK
	@GeneratedValue(strategy = GenerationType.AUTO) //for auto increment
	private long id;
	
	@Column(nullable = false) //we use column annotaion for constraints. this annotation is optional
	private String name;
	
	private double salary;
	
	@Column(nullable = false, unique = true)
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
