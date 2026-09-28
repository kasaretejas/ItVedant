package com.tejas.services;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.entities.Employee;
import com.tejas.repositories.EmployeeRepository;
import com.tejas.response_wrapper.ResponseWrapper;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ResponseWrapper responseWrapper;
	
	public ResponseWrapper getAllEmployees()
	{
		Iterator<Employee> allEmployees=employeeRepository.findAll().iterator();
		if(allEmployees.hasNext()) //since control is going on next, we can say, allEmployees has some data
		{
			responseWrapper.setMessage("Follwoing employees found");
			responseWrapper.setData(allEmployees);
			return responseWrapper;
		}
		else
		{
			responseWrapper.setMessage("There are no employees found");
			responseWrapper.setData(null);
			return responseWrapper;
		}
	}

	
	public ResponseWrapper addEmployee(Employee employee)
	{
		Employee savedEmployee=employeeRepository.save(employee);
		responseWrapper.setMessage("Following employee added");
		responseWrapper.setData(savedEmployee);
		return responseWrapper;
	}

	
	public ResponseWrapper getEmployeeById(long id)
	{
		Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent())
		{
			responseWrapper.setMessage("Following employee found with id "+id);
			responseWrapper.setData(employee.get());
			return responseWrapper;
		}
		else
		{
			responseWrapper.setMessage("No employee found with id "+id);
			responseWrapper.setData(null);
			return responseWrapper;
		}
	}

	
	public ResponseWrapper deleteEmployeeById(long id)
	{
		Optional<Employee> existingEmployee=employeeRepository.findById(id);
		if(existingEmployee.isPresent())
		{
			employeeRepository.deleteById(id);
			responseWrapper.setMessage("Employee with id "+id+" is deleted");
			responseWrapper.setData(null);
			return responseWrapper;
		}
		else
		{
			responseWrapper.setMessage("Employee with id "+id+" not exists");
			responseWrapper.setData(null);
			return responseWrapper;
		}
	}

	
	public ResponseWrapper updateEmployeeById(Employee employee, long id)
	{
		Optional<Employee> existingEmployee=employeeRepository.findById(id);
		if(existingEmployee.isPresent())
		{
			employee.setId(id);
			Employee updatedEmployee=employeeRepository.save(employee);
			responseWrapper.setMessage("Employee with id "+id+" is updated");
			responseWrapper.setData(updatedEmployee);
			return responseWrapper;
		}
		else
		{
			responseWrapper.setMessage("Employee with id "+id+" is not exists");
			responseWrapper.setData(null);
			return responseWrapper;
		}
	}

}















