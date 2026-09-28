package com.tejas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.entities.Category;
import com.tejas.entities.SubCategory;
import com.tejas.repositories.CategoryRepository;
import com.tejas.repositories.SubCategoryRepository;
import com.tejas.response_wrapper.UnivarsalResponse;

@Service
public class SubCategoryService {
	
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	UnivarsalResponse response;
	
	public ResponseEntity<?> addSubCategory(SubCategory subCategory)
	{
		Optional<Category> existingCategory=categoryRepository.findById(subCategory.getCategory().getId());
		if(existingCategory.isPresent())
		{
			subCategory.setCategory(existingCategory.get());
			SubCategory savedSubCategory=subCategoryRepository.save(subCategory);
			return response.send("SubCategory added", savedSubCategory, HttpStatus.OK);
		}
		else
		{
			return response.send("Category does not exists", null, HttpStatus.NOT_FOUND);
		}
	}
	
}
