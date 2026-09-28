package com.tejas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>
{
	List<Product> findAllByVendorId(long vendorId); //to get products for particular vendor
	
	Optional<Product> findByVendorIdAndId(long vendorId, long productId); //for update/delete product
}
