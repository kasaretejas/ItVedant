package com.tejas.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tejas.services.PetService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class PetController {
	
	@Autowired 
	PetService petService;
	
	@PostMapping("/admin/add-pet")
	private ResponseEntity<?> addPet(@RequestPart("pet") String petObjectStringify, 
		@RequestParam("file")MultipartFile file) throws IOException
	{
		return petService.addPet(petObjectStringify, file);
	}
	
	@GetMapping("/admin/pets")
	public ResponseEntity<?> getAllPets()
	{
		return petService.getAllPets();
	}
	
	
	
	
	@DeleteMapping("admin/delete-pet/{petId}")
	public ResponseEntity<?> deletePetById(@PathVariable long petId)
	{
		return petService.deletePetById(petId);
	}
	
	@GetMapping("/admin/pets/{petId}")
	public ResponseEntity<?> getPetById(@PathVariable long petId)
	{
		return petService.getPetById(petId);
	}
	
	
	
	@PutMapping("/admin/update-pet/{petId}")
	public ResponseEntity<?> updatePetById(@PathVariable long petId,@RequestPart("pet") String petObjectStringify,@RequestParam("file") MultipartFile file) throws IOException{
		return petService.updatePetById(petId,petObjectStringify, file);
	}
	
	
	@GetMapping("/admin/filter")
	public ResponseEntity<?> getfilterPets(
			@RequestParam(required = false) String typeName, 
			@RequestParam(required = false) String petName,
			@RequestParam(required = false) Integer  minAge,
			@RequestParam(required = false) Integer maxAge,
			@RequestParam(required = false) String sortDirection)
	{
		return petService.getfilterPets(typeName,petName, minAge, maxAge,sortDirection);
	}

	
	
	
	

}







