package com.tejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestEmployee 
{
	//property level injection
	@Autowired //used for injecting dependencies/beans created by spring OR built in beans in spring
	Employee employee; //no yet used
	
	@Autowired //constructor level injection (Rare)
	TestEmployee(Employee employee) //used below to call working() method of Employee
	{
		System.out.println("TestEmployee object created");
		employee.working();  //imagine  this is like this.age=age;
	}
	//there is setter level injection
}
