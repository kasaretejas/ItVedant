package com.tejas.controllers;

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
	public String addEmployee(@RequestBody Employee employeeObjectFromRequest)
	{
		return employeeService.addEmployee(employeeObjectFromRequest);
	}
	
	@GetMapping("/employees")
	public Employee  getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
}
