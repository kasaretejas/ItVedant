package com.tejas.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.Employee;
import com.tejas.services.EmployeeService;

@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employees")
	boolean addEmployee(@RequestBody Employee employee)
	{
		return employeeService.addEmployee(employee);
	}
	
	
	@GetMapping("/employees")
	ArrayList<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
}







