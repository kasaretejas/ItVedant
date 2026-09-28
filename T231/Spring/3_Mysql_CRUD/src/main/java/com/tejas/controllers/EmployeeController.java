package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.Employee;
import com.tejas.response_wrapper.CustomResponse;
import com.tejas.services.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	CustomResponse getAllEmployees() 
	{
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/employees")
	CustomResponse addEmployee(@RequestBody Employee employee) 
	{
		return employeeService.addEmployee(employee);
	}
	
	
	@PutMapping("/employees/{id}")
	CustomResponse updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id) 
	{
		return employeeService.updateEmployee(employee, id);
	}
	
	@DeleteMapping("/employees/{id}")
	public CustomResponse deleteEmployee(@PathVariable("id") long id) 
	{
		return employeeService.deleteEmployee(id);
	}
}



