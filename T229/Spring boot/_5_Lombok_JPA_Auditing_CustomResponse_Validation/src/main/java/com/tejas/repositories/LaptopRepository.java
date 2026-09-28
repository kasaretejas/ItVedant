package com.tejas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> 
{
	List<Laptop> findByPriceLessThan(double price);
	Optional<Laptop>  findByNameAndBrand(String name, String brand);
	List<Laptop> findByPriceBetween(double fromPrice, double toPrice);
	
}
