package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.Employee;
import com.tejas.servies.EmployeeService;

@RestController
public class EmployeeController 
{
	@Autowired 
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	Employee getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
}






