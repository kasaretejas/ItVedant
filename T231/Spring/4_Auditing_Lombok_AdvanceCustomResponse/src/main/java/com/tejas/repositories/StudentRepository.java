package com.tejas.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>
{
	//Optional<T> findById(ID id); 
	//select * from student where id=1
	
	
	Optional<Student> findByRollNumber(long rollNumber); //jpa methods
	//select * from student where rollNumber=2;
}
