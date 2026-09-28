package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.Category;
import com.tejas.responsewrapper.CustomResponse;
import com.tejas.services.CategoryService;


@RestController
@RequestMapping("/api/v1")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@PostMapping("/vendor/categories") //any api starts with vendor, will be only accessed by vendor
	public ResponseEntity<CustomResponse> addCategory(@RequestBody Category category)
	{
		return categoryService.addCategory(category);
	}
	
	@GetMapping("/get/categories") //any api starts with get, will be accessed by all
	public ResponseEntity<CustomResponse> getAllCategories()
	{
		return categoryService.getAllCategories();
	}
}
