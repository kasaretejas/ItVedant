package com.tejas.repositories;

import com.tejas.entities.Product;
import com.tejas.entities.Vendor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>
{
	List<Product> findAllByVendor(Vendor vendor);
	Optional<Product> findByVendorAndId(Vendor vendor, int productId);
}
