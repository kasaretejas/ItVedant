package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.custom_response.CustomResponse;
import com.tejas.entities.Pet;
import com.tejas.services.PetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class PetController {
	@Autowired
	PetService petService;
	
	@PostMapping("/pets")
	public CustomResponse addPet(@RequestBody @Valid Pet pet)
	{
		return petService.addPet(pet);
	}
	
	
	@GetMapping("/pets")
	public CustomResponse getAllPets()
	{
		return petService.getAllPets();
	}
	
	@PutMapping("/pets/{petId}")
	public ResponseEntity<CustomResponse> updatePetById(
			@RequestBody Pet pet, @PathVariable("petId") long petId)
	{
		return petService.updatePetById(pet, petId);
	}
	
	
	@GetMapping("/pets/name/{petName}")
	public ResponseEntity<CustomResponse> getPetByName(@PathVariable("petName") String petName)
	{
		return petService.getPetByName(petName);
	}
	
	//@GetMapping("/pets/category/{category}")
	@GetMapping("/pets/findByCategory/{category}")
	public ResponseEntity<CustomResponse> getPetByCategory(@PathVariable("category") String category)
	{
		return petService.getPetByCategory(category);
	}
	
	//findByCategoryAndBreed
	@GetMapping("/pets/category/{category}/breed/{breed}")
	public ResponseEntity<CustomResponse> getPetsByCategoryAndBreed(
			@PathVariable("category") String category, 
			@PathVariable("breed") String breed)
	{
		return petService.getPetsByCategoryAndBreed(category, breed);
	}
	
	@GetMapping("/pets/name/{name}/category/{category}")
	public ResponseEntity<CustomResponse> getPetsByNameOrCategory(
			@PathVariable("name") String name, 
			@PathVariable("category") String category)
	{
		return petService.getPetsByNameOrCategory(name, category);
	}
	
}
