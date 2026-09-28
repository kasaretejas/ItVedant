package com.tejas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.entities.Student;
import com.tejas.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	
	public String addStudent(Student student)
	{
		Student savedStudent=studentRepository.save(student);
		return "Student added";
	}

	public List<Student> getAllStudents()
	{
		List<Student> students=studentRepository.findAll();
		return students;
	}
	
	public String updateStudentById(Student student, long id)
	{
		if(studentRepository.existsById(id))
		{
			Student existingStudent=studentRepository.findById(id).get();
			student.setId(existingStudent.getId());
			studentRepository.save(student);
			return "student updated";
		}
		else
		{
			return "student id does not exists";
		}
	}
}









