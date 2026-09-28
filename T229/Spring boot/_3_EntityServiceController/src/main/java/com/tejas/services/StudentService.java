package com.tejas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tejas.entities.Student;

@Service
public class StudentService 
{
	ArrayList<Student> studentList = new ArrayList<>();
	
	public  boolean addStudent(Student student)
	{
		boolean isStudentAdded=studentList.add(student);
		return isStudentAdded;
	}
	
	public ArrayList<Student> getAllStudents()
	{
		return  studentList;
	}
	
	public List<Student> getStudentsByDiv(String div)
	{
		List<Student> filteredStudents=studentList
										.stream()
										.filter(student->student.getDiv().equals(div))
										.toList();
		return filteredStudents;
	}
}







