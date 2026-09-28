package com.tejas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tejas.entities.Employee;

@Service
public class EmployeeService 
{
	@Autowired
	Employee employee;
	
	public String addEmployee(Employee employeeObjectFromRequest)
	{
		employee.setId(employeeObjectFromRequest.getId());
		employee.setName(employeeObjectFromRequest.getName());
		employee.setSalary(employeeObjectFromRequest.getSalary());
		return "Employee added";
	}
	
	public Employee  getAllEmployees()
	{
		return employee;
	}
	
	
}
