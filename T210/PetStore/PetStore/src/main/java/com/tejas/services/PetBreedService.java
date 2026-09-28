package com.tejas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.models.PetBreed;
import com.tejas.models.PetType;
import com.tejas.repositories.PetBreedRepository;
import com.tejas.repositories.PetTypeRepository;
import com.tejas.responsewrapper.MyResponseWrapper;

@Service
public class PetBreedService 
{
	
	
	@Autowired
	PetBreedRepository petBreedRepository;
	
	@Autowired
	PetTypeRepository petTypeRepository;
	
	@Autowired
	MyResponseWrapper responseWrapper;
	
	private ResponseEntity<?> universalResponse(String message, Object data, HttpStatus httpStatus)
	{
		responseWrapper.setMessage(message);
		responseWrapper.setData(data);
		return new ResponseEntity<> (responseWrapper,httpStatus);
	}
	 
	
	public ResponseEntity<?> addBreedForPet(PetBreed petBreed, long petTypeId) {
		
		Optional<PetType> petType = petTypeRepository.findById(petTypeId);
		if(petType.isPresent()) {
			petBreed.setPetType(petType.get());
			PetBreed savedPetBreed = petBreedRepository.save(petBreed);
			return universalResponse("Pet Breed added successfully", savedPetBreed, HttpStatus.OK);
		} else {
			return universalResponse("There is no pet found by given pet id", null, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	public ResponseEntity<?> getAllPetBreeds() {
	    List<PetBreed> allBreeds = petBreedRepository.findAll();

	    if (allBreeds.isEmpty()) {
	        return universalResponse(
	            "No Pet Breeds found",
	            null,
	            HttpStatus.NOT_FOUND
	        );
	    } else {
	        return universalResponse(
	            "Following Pet Breeds found",
	            allBreeds,
	            HttpStatus.FOUND
	        );
	    }
	}
	
	
	public ResponseEntity<?> getPetBreedsByPetTypeId ( Long petTypeId ){
		
		List<PetBreed> filteredPetBreeds = petBreedRepository.findByPetType_Id(petTypeId);
		
		if(filteredPetBreeds.isEmpty()) {
			return universalResponse("There are no Pet breeds found ", null, HttpStatus.NOT_FOUND);
		}
		
		else {
			
			return universalResponse("Following breeds found", filteredPetBreeds, HttpStatus.FOUND);
		}
		
	}
	


}