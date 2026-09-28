package com.tejas.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.entities.Employee;
import com.tejas.repositories.EmployeeRepository;
import com.tejas.response_wrapper.CustomResponse;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	CustomResponse customResponse;
	
	public CustomResponse getAllEmployees() 
	{
		Iterator<Employee> employees=employeeRepository.findAll().iterator(); //select * from employee;
		if(employees.hasNext())
		{
			customResponse.setMessage("following employees found");
			customResponse.setData(employees);
			return customResponse;
		}
		else
		{
			customResponse.setMessage("there are no employees found");
			customResponse.setData(null);
			return customResponse;
		}
		
		
	}
	
	public CustomResponse addEmployee(Employee employee) 
	{
		Employee savedEmployee=employeeRepository.save(employee); //insert into employee ......
		customResponse.setMessage("follwoing employee added");
		customResponse.setData(savedEmployee);
		return customResponse;
	}
	
	public CustomResponse updateEmployee(Employee employee, long id) 
	{
		if(employeeRepository.existsById(id))
		{
			employee.setId(id);
			Employee updatedEmployee=employeeRepository.save(employee);
			customResponse.setMessage("Employe updated");
			customResponse.setData(updatedEmployee);
			return customResponse;
		}
		else
		{
			customResponse.setMessage("Employe id" + id + " does not exists");
			customResponse.setData(null);
			return customResponse;
		}
		
		
	}
	
	public CustomResponse deleteEmployee(long id) 
	{
		if(employeeRepository.existsById(id))
		{
			employeeRepository.deleteById(id);
			customResponse.setMessage("Employe with id" + id + " deleted");
			customResponse.setData(null);
			return customResponse;
		}
		else
		{
			customResponse.setMessage("Employe id " + id + " does not exists");
			customResponse.setData(null);
			return customResponse;
		}
	}
}








