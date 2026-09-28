package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.models.PetBreed;
import com.tejas.services.PetBreedService;

@RestController
@RequestMapping("/api/v1")
public class PetBreedController 
{
	@Autowired
	PetBreedService petBreedService;
	
	//only accessible by ADMIN
	@PostMapping("/admin/add-pet-breed/{petTypeId}")
	public ResponseEntity<?> addBreedForPet(@RequestBody PetBreed petBreed, @PathVariable("petTypeId") long petTypeId)
	{
		return petBreedService.addBreedForPet(petBreed, petTypeId);
	}
	
	//Public API
	@GetMapping("/get/pet-breeds")
	public ResponseEntity<?> getAllPetBreeds()
	{
		return petBreedService.getAllPetBreeds();
	}
	
	@GetMapping("/admin/findBreedByPetTypeId/{petTypeId}")
	public ResponseEntity<?> getPetBreedsByPetTypeId(@PathVariable("petTypeId") long petTypeId)
	{
		return petBreedService.getPetBreedsByPetTypeId(petTypeId);
	}
		
}
