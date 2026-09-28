package com.tejas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestStudent 
{

	@Bean
	Student createStudentObject()
	{
		Student s1 = new Student(10, "raj");
		return s1;
	}
}
