package com.tejas;

import org.springframework.stereotype.Component;

@Component //Student s = new Student();
public class Student 
{
	Student()
	{
		System.out.println("Student object created");
	}
	
	void study()
	{
		System.out.println("Student is studying Java");
	}
}
