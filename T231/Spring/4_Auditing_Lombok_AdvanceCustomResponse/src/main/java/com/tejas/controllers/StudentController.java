package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.Student;
import com.tejas.response_wrapper.CustomRepsonse;
import com.tejas.services.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	private ResponseEntity<CustomRepsonse> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@PostMapping("/students")
	public ResponseEntity<CustomRepsonse> addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@PutMapping("/students/{rollNumber}")
	public ResponseEntity<CustomRepsonse> updateStudent(@RequestBody Student student, @PathVariable("rollNumber") long rollNumber)
	{
		return studentService.updateStudent(student, rollNumber);
	}

}
