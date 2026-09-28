package com.tejas.annotations;

import org.springframework.stereotype.Component;

@Component
public class Student 
{
	Student()
	{
		System.out.println("Student object is created");
	}
	
	void homework()
	{
		System.out.println("student doing home work");
	}
}
