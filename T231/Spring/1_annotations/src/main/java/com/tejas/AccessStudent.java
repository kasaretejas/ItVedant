package com.tejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessStudent 
{
	//@Autowired //asking spring to inject object
	//Student student ;
	
	@Autowired
	AccessStudent(Student student)
	{
		System.out.println("AccessStudent object created");
		student.study();
	}
}
