package com.tejas;

import org.springframework.stereotype.Component;

public class Student 
{
	int rollNo;
	String name;
	Student(int rollNo, String name) 
	{
		this.rollNo = rollNo;
		this.name = name;
		System.out.println("Student object is created by developer but managed by spring");
	}
	
	
}
