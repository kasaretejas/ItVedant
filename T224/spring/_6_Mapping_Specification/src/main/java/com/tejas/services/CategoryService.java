package com.tejas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.entities.Category;
import com.tejas.repositories.CategoryRepository;
import com.tejas.responsewrapper.CustomResponse;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CustomResponse response;
	
	public ResponseEntity<CustomResponse> addCategory(Category category)
	{
		Category savedCategory=categoryRepository.save(category);
		response.setMessage("Follwoing Category added");
		response.setData(savedCategory);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<CustomResponse> getAllCategories()
	{
		List<Category> categories=categoryRepository.findAll();
		response.setMessage("Follwoing Categories found");
		response.setData(categories);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
