package com.tejas;

import org.springframework.stereotype.Component;

@Component  //Student student = new Student();
public class Student 
{
	public Student() 
	{
		System.out.println("---- student object created -----");
	}
	
	void task()
	{
		System.out.println("Student is doing homework");
	}
}
