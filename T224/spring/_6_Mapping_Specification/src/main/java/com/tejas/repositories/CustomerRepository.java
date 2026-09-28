package com.tejas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
