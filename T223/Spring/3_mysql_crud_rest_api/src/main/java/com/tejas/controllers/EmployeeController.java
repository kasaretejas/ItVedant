package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.Employee;
import com.tejas.response_wrapper.ResponseWrapper;
import com.tejas.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseWrapper getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/employees")
	private ResponseWrapper addEmployee(@RequestBody Employee employee)
	{
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/employees/{id}")
	private ResponseWrapper getEmployeeById(@PathVariable long id)
	{
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("/employees/{id}")
	private ResponseWrapper deleteEmployeeById(@PathVariable long id)
	{
		return employeeService.deleteEmployeeById(id);
	}
	
	
	@PutMapping("/employees/{id}")
	private ResponseWrapper updateEmployeeById(@RequestBody Employee employee, @PathVariable long id)
	{
		return employeeService.updateEmployeeById(employee, id);
	}

}









