package com.tejas.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double salary;
	
	@OneToOne //mapping annotation doesnt create column
	@JoinColumn(name="address_id") //for SQL
	private Address address;
	
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	
	@OneToMany(mappedBy = "employee")
	private List<BankAccount> bankAccount;
	
	
	@ManyToMany
	@JoinTable(
			   name="employee_project",
			   joinColumns = @JoinColumn(name="employee_id"),
			   inverseJoinColumns = @JoinColumn(name="project_id"))
	private List<Project> project;
}












