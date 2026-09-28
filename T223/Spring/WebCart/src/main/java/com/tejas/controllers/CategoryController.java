package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.Category;
import com.tejas.response_wrapper.ResponseWrapper;
import com.tejas.services.CategoryService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class CategoryController 
{
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/vendor/categories")
	public ResponseEntity<ResponseWrapper> addCategory(@RequestBody Category category)
	{
		return categoryService.addCategory(category);
	}
	
	//@GetMapping("/vendor/categories")
	@GetMapping("/get/categories")
	public ResponseEntity<ResponseWrapper> getAllCategories()
	{
		return categoryService.getAllCategories();
	}
}





















