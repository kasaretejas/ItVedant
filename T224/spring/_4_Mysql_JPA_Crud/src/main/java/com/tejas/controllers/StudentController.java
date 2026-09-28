package com.tejas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.Student;
import com.tejas.services.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/students")
	public String addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	
	@PutMapping("/students/{id}")
	public String updateStudentById(@RequestBody Student student, @PathVariable("id") long id)
	{
		return studentService.updateStudentById(student, id);
	}

}






