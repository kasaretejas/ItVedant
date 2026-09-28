package com.tejas.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.tejas.models.Pet;
import com.tejas.models.PetBreed;
import com.tejas.repositories.PetBreedRepository;
import com.tejas.repositories.PetRepository;
import com.tejas.responsewrapper.MyResponseWrapper;
import com.tejas.specifications.PetSpecification;

import tools.jackson.databind.ObjectMapper;

@Service
public class PetService 
{
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	PetBreedRepository petBreedRepository;
	
	@Autowired
	MyResponseWrapper responseWrapper;
	
	private static final String UPLOAD_DIR= System.getProperty("user.dir")+"/uploads/images/";
	
	private ResponseEntity<?> universalResponse(String message, Object data, HttpStatus httpStatus)
	{
		responseWrapper.setMessage(message);
		responseWrapper.setData(data);
		return new ResponseEntity<> (responseWrapper,httpStatus);
	}
	
	public ResponseEntity<?> addPet(String petObjectStringify, MultipartFile file) throws IOException{
		
//		converting petObject which is in string into pet object
		ObjectMapper objectMapper = new ObjectMapper();
		Pet pet = objectMapper.readValue(petObjectStringify, Pet.class);
		
//		collecting
		long petBreedId = pet.getPetBreed().getId();
		PetBreed petBreed  =petBreedRepository.findById(petBreedId).get();
		
//		storing/saving/writing file into our uploads/images folder
		String originalFileName = file.getOriginalFilename();
		Path filePath   = Paths.get(UPLOAD_DIR, originalFileName);
		Files.write(filePath, file.getBytes());
		
//		building pet object by adding pet image path and pet breed
		pet.setImageName(originalFileName);
		pet.setPetBreed(petBreed);
		
		Pet savedPet = petRepository.save(pet);
		return universalResponse("Pet added successfully", savedPet, HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<?> getAllPets()
	{
		List<Pet> pets=petRepository.findAll();
		if(pets.size()==0)
		{
			return universalResponse("There are no pets", null, HttpStatus.NOT_FOUND);
		}
		else
		{
			return universalResponse("Following pets found", pets, HttpStatus.OK);
		}
	}
	
	
	public ResponseEntity<?> deletePetById(long petId)
	{
		Optional<Pet> pet=petRepository.findById(petId);
		if(pet.isPresent())
		{
			//delete
			petRepository.deleteById(petId);
			return universalResponse("Pet deleted!", null, HttpStatus.OK);
		}
		else
		{
			return universalResponse("There is no pet with id "+petId,  null, HttpStatus.NOT_FOUND);
		}
	}
	

	public ResponseEntity<?> getPetById(long petId)
	{
		Optional<Pet> pet=petRepository.findById(petId);
		if(pet.isPresent())
		{
			return universalResponse("Follwoing pet found!", pet.get(), HttpStatus.FOUND);
		}
		else
		{
			return universalResponse("There is no pet with id "+petId, null, HttpStatus.NOT_FOUND);
		}
	}
	
	
	public ResponseEntity<?> updatePetById(long petId, String petObjectStringify, MultipartFile file) throws IOException{
		//finding pet by its id
		Optional<Pet> existingPet=petRepository.findById(petId);
		if(existingPet.isPresent())
		{
			//converting petObject which is in string into pet object
			ObjectMapper objectMapper = new ObjectMapper();
			Pet pet = objectMapper.readValue(petObjectStringify, Pet.class);
			
			//collecting petBreed data from petBreedId
			long petBreedId = pet.getPetBreed().getId();
			PetBreed petBreed  =petBreedRepository.findById(petBreedId).get();
			
			//storing/saving/writing file into our uploads/images folder
			String originalFileName = file.getOriginalFilename();
			Path filePath   = Paths.get(UPLOAD_DIR, originalFileName);
			Files.write(filePath, file.getBytes());
			
			//building pet object by adding pet image path and pet breed
			pet.setId(petId); //if not set then it will create new pet record instead of update
			pet.setImageName(originalFileName);
			pet.setCreatedAt(existingPet.get().getCreatedAt());
			pet.setPetBreed(petBreed);
			
			Pet savedPet = petRepository.save(pet);
			return universalResponse("Pet Updated successfully", savedPet, HttpStatus.CREATED);
		}
		else
		{
			return universalResponse("Pet with given id does not exist", null, HttpStatus.NOT_FOUND);
			
		}
		
		
	}
	
	
	
	
	
	public ResponseEntity<?> getfilterPets(String typeName, String petName, 
			Integer minAge, Integer maxAge,String sortDirection)
	{
		Specification<Pet> allFilters=Specification.where(PetSpecification.hasPetType(typeName))
													.and(PetSpecification.nameContains(petName))
													.and(PetSpecification.hasAgeBetween(minAge, maxAge))
													.and(PetSpecification.sortByAge(sortDirection));
	
		 List<Pet> filteredPets=petRepository.findAll(allFilters);
		 
		 return universalResponse("Follwoing filtered pets found", filteredPets, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
