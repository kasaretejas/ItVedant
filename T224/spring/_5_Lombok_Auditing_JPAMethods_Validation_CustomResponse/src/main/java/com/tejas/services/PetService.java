package com.tejas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.custom_response.CustomResponse;
import com.tejas.entities.Pet;
import com.tejas.repositories.PetRepository;

@Service
public class PetService {
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	CustomResponse customResponse;
	
	public CustomResponse addPet(Pet pet)
	{
		Pet savedPet=petRepository.save(pet);
		customResponse.setMessage("Follwoing pet added");
		customResponse.setData(savedPet);
		return customResponse;
	}
	
	public CustomResponse getAllPets()
	{
		List<Pet> pets=petRepository.findAll();
		customResponse.setMessage("Following pets found");
		customResponse.setData(pets);
		return customResponse;
	}
	
	public ResponseEntity<CustomResponse> updatePetById(Pet pet, long petId)
	{
		if(petRepository.existsById(petId))
		{
			//update logic
			Pet existingPet=petRepository.findById(petId).get();
			
			pet.setId(existingPet.getId());
			pet.setCreatedAt(existingPet.getCreatedAt());
			
			Pet updatedPet=petRepository.save(pet);
			
			customResponse.setMessage("Pet Updated!");
			customResponse.setData(updatedPet);
			
			return new ResponseEntity<>(customResponse, HttpStatus.OK);
		}
		else
		{
			customResponse.setMessage("Pet with id "+petId+" does not exists");
			customResponse.setData(null);
			return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<CustomResponse> getPetByName(String petName)
	{
		List<Pet> pets=petRepository.findByName(petName);
		if(pets.isEmpty())
		{
			customResponse.setMessage("There are no pets with name "+petName);
			customResponse.setData(null);
			return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
		}
		else
		{
			customResponse.setMessage("Following pets found with name "+petName);
			customResponse.setData(pets);
			return new ResponseEntity<>(customResponse, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<CustomResponse> getPetByCategory(String category)
	{
		List<Pet> pets=petRepository.findByCategory(category);
		if(pets.isEmpty())
		{
			customResponse.setMessage("There are no pets with category "+category);
			customResponse.setData(null);
			return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
		}
		else
		{
			customResponse.setMessage("Following pets found with category "+category);
			customResponse.setData(pets);
			return new ResponseEntity<>(customResponse, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<CustomResponse> getPetsByCategoryAndBreed(String category, String breed)
	{
		List<Pet> pets=petRepository.findByCategoryAndBreed(category,breed);
		if(pets.isEmpty())
		{
			customResponse.setMessage("There are no pets with category "+category + " and breed "+ breed);
			customResponse.setData(null);
			return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
		}
		else
		{
			customResponse.setMessage("Following pets found with category "+category + " and breed "+ breed);
			customResponse.setData(pets);
			return new ResponseEntity<>(customResponse, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<CustomResponse> getPetsByNameOrCategory(String name, String category)
	{
		List<Pet> pets=petRepository.findByNameOrCategory(name,category);
		if(pets.isEmpty())
		{
			customResponse.setMessage("There are no pets with category "+category + " or name "+ name);
			customResponse.setData(null);
			return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
		}
		else
		{
			customResponse.setMessage("Following pets found with category "+category + " or  name "+ name);
			customResponse.setData(pets);
			return new ResponseEntity<>(customResponse, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<CustomResponse> getPetsByAgeBetween(int ageMin, int ageMax)
	{
		List<Pet> pets=petRepository.findByAgeBetween(ageMin,ageMax);
		if(pets.isEmpty())
		{
			customResponse.setMessage("There are no pets between age "+ageMin + "-"+ ageMax);
			customResponse.setData(null);
			return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
		}
		else
		{
			customResponse.setMessage("Following pets found between age "+ageMin +"-"+ ageMax);
			customResponse.setData(pets);
			return new ResponseEntity<>(customResponse, HttpStatus.OK);
		}
	}

}




