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
public class PetController {
	
	@Autowired 
	PetService petService;
	
	//Only by ADMIN
	@PostMapping("/admin/add-pet")
	private ResponseEntity<?> addPet(@RequestPart("pet") String petObjectStringify, 
		@RequestParam("file")MultipartFile file) throws IOException
	{
		return petService.addPet(petObjectStringify, file);
	}
	
	//@GetMapping("/admin/pets")
	//public API
	@GetMapping("/get/pets")
	public ResponseEntity<?> getAllPets()
	{
		return petService.getAllPets();
	}
	
	
	
	//only by ADMIN
	@DeleteMapping("admin/delete-pet/{petId}")
	public ResponseEntity<?> deletePetById(@PathVariable("petId") long petId)
	{
		return petService.deletePetById(petId);
	}
	
	//public API
	@GetMapping("/get/pets/{petId}")
	public ResponseEntity<?> getPetById(@PathVariable("petId") long petId)
	{
		return petService.getPetById(petId);
	}
	
	
	//only by ADMIN
	@PutMapping("/admin/update-pet/{petId}")
	public ResponseEntity<?> updatePetById(@PathVariable("petId") long petId,@RequestPart("pet") String petObjectStringify,@RequestParam("file") MultipartFile file) throws IOException{
		return petService.updatePetById(petId,petObjectStringify, file);
	}
	

	//public API
	@GetMapping("/filter")
	public ResponseEntity<?> getfilterPets(
	    @RequestParam(name = "typeName", required = false) String typeName,
	    @RequestParam(name = "petName", required = false) String petName,
	    @RequestParam(name = "minAge", required = false) Integer minAge,
	    @RequestParam(name = "maxAge", required = false) Integer maxAge,
	    @RequestParam(name = "sortDirection", required = false) String sortDirection)
	{
	    return petService.getfilterPets(typeName, petName, minAge, maxAge, sortDirection);
	}
	
	
	
	
	

}







