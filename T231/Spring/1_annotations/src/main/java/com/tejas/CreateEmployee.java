package com.tejas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateEmployee 
{
	@Bean
	Employee createObjecOfEmployee1()
	{
		Employee e1 = new Employee(10, "amit", 25000);
		return e1;
	}
}












