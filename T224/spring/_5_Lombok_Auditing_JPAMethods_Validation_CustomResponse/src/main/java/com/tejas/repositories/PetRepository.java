package com.tejas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{
	List<Pet> findByName(String petName);
	List<Pet> findByCategory(String category);
	
	List<Pet> findByCategoryAndBreed(String category, String breed);
	List<Pet> findByNameOrCategory(String name, String category);
	
	List<Pet> findByAgeBetween(int ageMin, int ageMax);
}
