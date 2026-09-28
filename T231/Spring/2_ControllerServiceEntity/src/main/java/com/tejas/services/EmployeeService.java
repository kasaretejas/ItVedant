package com.tejas.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.tejas.entities.Employee;

@Service
public class EmployeeService 
{
	ArrayList<Employee> employeeList = new ArrayList<>();
	
	public boolean addEmployee(Employee employee)
	{
		//insert into employee (id, name, salary) values(12, "amit", 20000);
		boolean isEmployeeAdded=employeeList.add(employee);
		return isEmployeeAdded;
	}
	
	public ArrayList<Employee> getAllEmployees()
	{
		return employeeList;
	}
}







