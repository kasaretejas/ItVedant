package com.tejas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>
{
	//to check product already exists in the cart and to add in the cart
	boolean  existsByCustomerIdAndProductId(long customerId, long productId);
	Optional<Cart>  findByCustomerIdAndProductId(long customerId, long productId);
	
	//to get cart products by customer id
	List<Cart> findByCustomerId(long customerId);
}
