package com.tejas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.models.PetType;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long>
{
	
}
