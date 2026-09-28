package com.tejas;

import org.springframework.stereotype.Component;

@Component
public class Employee 
{
	Employee()
	{
		System.out.println("Employee Object is created");
	}
	
	void working()
	{
		System.out.println("employee is working");
	}
}
