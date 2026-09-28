package com.tejas.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateEmployeeObject 
{
	@Bean
	Employee createEmployeeObject1()
	{
		
		Employee employee1 = new Employee(10, "raj", 25000);
		System.out.println("employee1 object created");
		return employee1;
	}
	
	Employee createEmployeeObject2()
	{
		Employee employee2 = new Employee(20, "rani", 35000);
		System.out.println("employee2 object created");
		return employee2;
	}
}
