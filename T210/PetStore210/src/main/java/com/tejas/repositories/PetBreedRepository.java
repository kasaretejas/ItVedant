package com.tejas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.models.PetBreed;
import com.tejas.models.PetType;

@Repository
public interface PetBreedRepository extends JpaRepository<PetBreed, Long>
{
	//JPA method to get pet type based on pet type id
	List<PetBreed> findByPetType_Id(long petTypeId);
}
