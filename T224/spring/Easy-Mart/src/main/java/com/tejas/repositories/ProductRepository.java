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
	//below JPA method is to get products for particular vendor
	List<Product> findAllByVendorId(long vendorId);
	//below JPA method is to get product by particular vendor id and product id
	//this method will be useful when vendor try to update,get or delete particular product
	Optional<Product> findByVendorIdAndId(long vendorId, long productId);
	
}
