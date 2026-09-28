package com.tejas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.tejas.entities.Student;
import com.tejas.services.StudentService;

@RestController
public class StudentController 
{
	@Autowired
	StudentService studentService;
	
	@PostMapping("/students")  
	private boolean addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@GetMapping("/students")
	private ArrayList<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping("/students/{div}")
	public List<Student> getStudentsByDiv(@PathVariable("div") String div)
	{
		return studentService.getStudentsByDiv(div);
	}
}





