package com.tejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessStudentClassMemebrs 
{
	@Autowired //field level injection
	Student student; //SpringBoot will inject object of Student class into this student reference variable
	
	@Autowired //constructor level injection
	public AccessStudentClassMemebrs(Student student) 
	{
		//Student student = new Student();
		student.task();
	}
}