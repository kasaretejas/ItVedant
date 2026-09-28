package com.tejas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
