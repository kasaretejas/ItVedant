package com.tejas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
