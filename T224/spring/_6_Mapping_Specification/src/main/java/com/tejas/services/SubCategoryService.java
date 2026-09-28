package com.tejas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.entities.Category;
import com.tejas.entities.SubCategory;
import com.tejas.repositories.CategoryRepository;
import com.tejas.repositories.SubCategoryRepository;
import com.tejas.responsewrapper.CustomResponse;

@Service
public class SubCategoryService {
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	CustomResponse response; 
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public ResponseEntity<CustomResponse> addSubCategory(SubCategory subCategory)
	{
		long categoryId=subCategory.getCategory().getId();
		
		if(categoryRepository.existsById(categoryId))
		{
			Category existingCategory=categoryRepository.findById(categoryId).get();
			subCategory.setCategory(existingCategory); //setting FK of category to sub category
			
			SubCategory savedSubCategory=subCategoryRepository.save(subCategory);
			
			response.setMessage("Sub Category Added");
			response.setData(savedSubCategory);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else
		{
			response.setMessage("Category with id "+categoryId+" does not exists");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		
	}
}
