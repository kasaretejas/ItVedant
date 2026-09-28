package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.SubCategory;
import com.tejas.services.SubCategoryService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class SubCategoryController 
{
	@Autowired
	SubCategoryService subCategoryService;
	
	@PostMapping("/vendor/sub-categories/{categoryId}")
	public ResponseEntity<?> addSubCategory(@PathVariable("categoryId") int categoryId,
			@RequestBody SubCategory subCategory)
	{
		return subCategoryService.addSubCategory(categoryId, subCategory);
	}
}












