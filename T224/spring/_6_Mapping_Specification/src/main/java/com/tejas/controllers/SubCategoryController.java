package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.SubCategory;
import com.tejas.repositories.SubCategoryRepository;
import com.tejas.responsewrapper.CustomResponse;
import com.tejas.services.SubCategoryService;

@RestController
@RequestMapping("/api/v1")
public class SubCategoryController {
	@Autowired
	SubCategoryService subCategoryService;
	
	@PostMapping("/vendor/subcategories")
	public ResponseEntity<CustomResponse> addSubCategory(@RequestBody SubCategory subCategory)
	{
		return subCategoryService.addSubCategory(subCategory);
	}

}
