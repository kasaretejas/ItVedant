package com.tejas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatingEmployeeObject 
{
//	@Bean
//	void employeeObj1()
//	{
//		Employee e1 = new Employee("emp1", "1234", 34);
//	}
	
	@Bean
	Employee employeeObj2()
	{
		Employee e2 = new Employee("emp2", "2345", 35);
		return e2;
	}
	
	@Bean
	Employee employeeObj3()
	{
		Employee e3 = new Employee("emp3", "2345", 36);
		return e3;
	}
	
	Employee employeeObj4()
	{
		Employee e3 = new Employee("emp4", "2345", 36);
		return e3;
	}
}
