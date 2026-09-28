package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.SubCategory;
import com.tejas.response_wrapper.ResponseWrapper;
import com.tejas.services.SubCategoryService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class SubCategoryController 
{
	@Autowired
	SubCategoryService subCategoryService;
	
	@PostMapping("/vendor/subcategories")
	private ResponseEntity<ResponseWrapper> addSubCategory(@RequestBody SubCategory subCategory)
	{
		return subCategoryService.addSubCategory(subCategory);
	}
	
	//@GetMapping("/vendor/subcategories")
	@GetMapping("/get/subcategories")
	private ResponseEntity<ResponseWrapper> getAllSubCategories()
	{
		return subCategoryService.getAllSubCategories();
	}
}




















