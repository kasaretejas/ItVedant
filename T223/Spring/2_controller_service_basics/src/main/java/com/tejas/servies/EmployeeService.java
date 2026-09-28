package com.tejas.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.entities.Employee;

@Service
public class EmployeeService 
{
	@Autowired
	Employee employee;
	
	public Employee getAllEmployees()
	{
		employee.setId(10);
		employee.setName("Raj");
		return employee;
	}
}
