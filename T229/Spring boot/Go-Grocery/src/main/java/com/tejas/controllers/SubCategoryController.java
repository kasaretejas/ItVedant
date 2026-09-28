package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.tejas.custom_response.CustomResponse;
import com.tejas.entities.SubCategory;
import com.tejas.services.SubCategoryService;

@RestController
@RequestMapping("/api/v1")
public class SubCategoryController 
{
	@Autowired
	SubCategoryService subCategoryService;
	
	@PostMapping("/vendor/subcategories")
	private ResponseEntity<CustomResponse> addSubCategory(@RequestBody SubCategory subCategory)
	{
		return subCategoryService.addSubCategory(subCategory);
	}
	
	@GetMapping("/vendor/subcategories/{userId}")
	private ResponseEntity<CustomResponse> getSubcategoriesByVendor(@PathVariable("userId") long userId)
	{
		return subCategoryService.getSubcategoriesByVendor(userId);
	}
}







