package com.tejas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
	//getting products for particular vendor by vendor's id
	List<Product> findAllByVendorId(long vendorId);
	
	//getting single product by vendor's id and product's id  (to update/delete product)
	Optional<Product> findByVendorIdAndId(long vendorId, long productId);
}
