package com.tejas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Cart;

@Repository
public interface CartRepository extends  JpaRepository<Cart, Long>
{
	boolean existsByCustomerIdAndProductId(long customerId, long productId);
	List<Cart> findByCustomerId(long customerId);
	
}
