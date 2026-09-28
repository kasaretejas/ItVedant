package com.tejas.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestStudentObject {
	//field level injection
	//@Autowired
	//Student student;
	
	//constructor level injection
	@Autowired
	TestStudentObject(Student student)
	{
		System.out.println("TestStudentObject object is created");
		student.homework();
	}

}
