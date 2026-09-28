package com.tejas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.models.PetType;
import com.tejas.repositories.PetTypeRepository;
import com.tejas.responsewrappers.MyResponseWrapper;

@Service
public class PetTypeService {
    
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
	public ResponseEntity<?> addPetType(PetType petType)
	{
		if(petType.getTypeName().length()<3 || petType == null)
		{
			return universalResponse("Please enter valid pet Type", null, HttpStatus.BAD_REQUEST);
		}else {
			PetType savedPetType = petTypeRepository.save(petType);
			return universalResponse("Pet type added successfully", savedPetType, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<?> getAllPetTypes()
	{
		 List<PetType> petTypes= petTypeRepository.findAll();
		 if(petTypes.size()==0)
		 {
			 return universalResponse("There are no pet types found", null, HttpStatus.NOT_FOUND);
		 }else {
			 return universalResponse("List of All pet types", petTypes, HttpStatus.FOUND);
		 }
	}
	
}
