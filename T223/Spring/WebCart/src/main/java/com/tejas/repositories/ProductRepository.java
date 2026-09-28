package com.tejas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Product;
import com.tejas.entities.Vendor;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>
{
	//to get all products added by specific vendor
	List<Product> findAllByVendor(Vendor vendor);
	
	//to get product by its id and vendor (useful in delete, update of product)
	Optional<Product> findByVendorAndId(Vendor vendor, Long id);
}
