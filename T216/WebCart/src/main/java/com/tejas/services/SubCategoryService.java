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
import com.tejas.response.UnivesalResponse;

@Service
public class SubCategoryService 
{
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	UnivesalResponse response;
	
	public ResponseEntity<?> addSubCategory(int categoryId, SubCategory subCategory)
	{
		Optional<Category> existingCategory = categoryRepository.findById(categoryId);
		if(existingCategory.isPresent())
		{
			subCategory.setCategory(existingCategory.get());
			SubCategory savedSubCategory = subCategoryRepository.save(subCategory);
			return response.send("sub category added", savedSubCategory, HttpStatus.CREATED);
		}
		else
		{
			return response.send("Category id does not exist", null, HttpStatus.NOT_FOUND);
		}
	}
}










