package com.tejas.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.tejas.models.Pet;
import com.tejas.models.PetBreed;
import com.tejas.models.PetType;

import jakarta.persistence.criteria.Join;

public class PetSpecification {
	public static Specification<Pet> hasPetType(String typeName)
	{
		return (root, query, cb)-> {
			if(typeName==null)
			{
				return null;    
			}
			else
			{
				// Join Pet → PetBreed
	            Join<Pet, PetBreed> petBreedJoin = root.join("petBreed");
	            
	         // Join PetBreed → PetType
	            Join<PetBreed, PetType> petTypeJoin = petBreedJoin.join("petType");
	            
	            // Filter by typeName (e.g. "cat", "dog")
	            return cb.equal(cb.lower(petTypeJoin.get("typeName")), typeName.toLowerCase());
			}
		};	
	}
	
	public static Specification<Pet> nameContains(String petName)
	{
		return (root, query, cb) ->
			petName==null? null : cb.like(cb.lower(root.get("name")),"%" + petName.toLowerCase() +"%"); 
	}
	
	
	public static Specification<Pet> hasAgeBetween(Integer minAge, Integer maxAge)
	{
		return (root, query, cb) -> {
			if(minAge==null && maxAge==null)
			{
				return null;
			}
			else
			{
				return cb.between(root.get("age"), minAge, maxAge);
			}
		};
	}
	
	public static Specification<Pet> sortByAge(String sortDirection)
	{
		return (root, query, cb) -> {
			if(sortDirection==null)
			{
				return null;
			}
			if(sortDirection.equalsIgnoreCase("asc"))
			{
				query.orderBy(cb.asc(root.get("age")));
			}
			else
			{
				query.orderBy(cb.desc(root.get("age")));
			}
			return null;
		
		};
	}
	
	
	
	
	
	
	
	
	
	
	
}
