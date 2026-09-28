package com.tejas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> 
{
	Optional<Vendor> findByUserId(long userID);
}
