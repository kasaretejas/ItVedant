package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.models.PetType;
import com.tejas.services.PetTypeService;

@RestController
@RequestMapping("/api/v1")
public class PetTypeController 
{
	@Autowired
	PetTypeService petTypeService;
	
	//only accessible by ADMIN
	@PostMapping("/admin/add-pet-type")
	public ResponseEntity<?> addPetType(@RequestBody PetType petType)
	{
		return petTypeService.addPetType(petType);
	}
	
	//public API
	@GetMapping("/get/pet-types")
	public ResponseEntity<?> getAllPetTypes()
	{
		return petTypeService.getAllPetTypes();
	}
}
