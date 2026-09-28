package com.tejas.services;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.entities.Student;
import com.tejas.repositories.StudentRepository;
import com.tejas.response_wrapper.CustomRepsonse;
import com.tejas.response_wrapper.Response;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	Response response;
	
	public ResponseEntity<CustomRepsonse> getAllStudents()
	{
		Iterator<Student> students=studentRepository.findAll().iterator();
		return response.send("Following students found", students, HttpStatus.OK);
	}
	
	public ResponseEntity<CustomRepsonse> addStudent(Student student)
	{
		Student savedStudent=studentRepository.save(student);
		return response.send("Student added", savedStudent, HttpStatus.OK);
	}
	
	public ResponseEntity<CustomRepsonse> updateStudent(Student student, long rollNumber) 
	//the student object we are sending is having only name
	{
		Optional<Student> optinalStudent=studentRepository.findByRollNumber(rollNumber);
		if(optinalStudent.isPresent())
		{
			//for update we have : name and rollNumber
			Student existingStudent=optinalStudent.get(); //we will collect createdAt, updatedAt from here
			student.setCreatedAt(existingStudent.getCreatedAt());
			student.setRollNumber(existingStudent.getRollNumber());
			Student updatedStudent=studentRepository.save(student);
			return response.send("Student Updated", updatedStudent, HttpStatus.OK);
			
		}
		else
		{
			return response.send("There is no student with roll number "+rollNumber, null, HttpStatus.NOT_FOUND);
		}
	}
	

}
