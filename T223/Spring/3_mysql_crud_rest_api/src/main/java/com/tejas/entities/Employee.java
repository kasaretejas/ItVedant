package com.tejas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity(name = "employee_table") //this will create table with name employee_table in crud database
@Entity //this will create table with name employee(given below) in crud database
public class Employee 
{
	@Id //this will make id as PK
	@GeneratedValue(strategy = GenerationType.AUTO) //auto increment
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private float salary;
	
	@Column(nullable = false)
	private String city;

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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
