package com.tejas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Customer;
import com.tejas.entities.Vendor;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> 
{
	boolean existsByPhone(String phone);
	boolean existsByEmail(String email);
	
	Optional<Customer> findByUserId(long userId);
}



