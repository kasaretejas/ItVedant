package com.tejas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tejas.entities.Customer;
import com.tejas.entities.User;
import com.tejas.entities.Vendor;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByUser(User user);
}
