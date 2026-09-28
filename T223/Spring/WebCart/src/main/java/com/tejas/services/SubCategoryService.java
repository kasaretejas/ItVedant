package com.tejas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.entities.Category;
import com.tejas.entities.SubCategory;
import com.tejas.repositories.CategoryRepository;
import com.tejas.repositories.SubCategoryRepository;
import com.tejas.response_wrapper.ResponseWrapper;
import com.tejas.response_wrapper.UniversalResponse;

@Service
public class SubCategoryService 
{
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	UniversalResponse response;
	
	public ResponseEntity<ResponseWrapper> addSubCategory(SubCategory subCategory)
	{
		long categoryId=subCategory.getCategory().getId();
		Optional<Category> existingCategory=categoryRepository.findById(categoryId);
		if(existingCategory.isPresent())
		{
			subCategory.setCategory(existingCategory.get());
			SubCategory savedSubCategory=subCategoryRepository.save(subCategory);
			return response.send("SubCategory Added!", savedSubCategory, HttpStatus.OK);
		}
		else
		{
			return response.send("SubCategory Does not exists!", null, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseWrapper> getAllSubCategories()
	{
		List<SubCategory> subCategories=subCategoryRepository.findAll();
		if(subCategories.size()>0)
		{
			return response.send("SubCategories found", subCategories, HttpStatus.FOUND);
		}
		else
		{
			return response.send("SubCategories not found", null, HttpStatus.NOT_FOUND);
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
}
