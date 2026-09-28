package com.tejas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
