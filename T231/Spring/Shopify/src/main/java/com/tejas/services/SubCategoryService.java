package com.tejas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.entities.SubCategory;
import com.tejas.repositories.SubCategoryRepository;
import com.tejas.response_wrapper.CustomResponse;
import com.tejas.response_wrapper.Response;

@Service
public class SubCategoryService {
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	Response response;
	
	public ResponseEntity<CustomResponse> addSubCategory(SubCategory subCategory)
	{
		if(subCategoryRepository.existsByNameAndCategoryId(subCategory.getName(), subCategory.getCategory().getId()))
		{
			return response.send("Sub Category Already exists", null, HttpStatus.FOUND);
		}
		else
		{
			subCategory.setCategory(subCategory.getCategory()); //setting up FK of category for sub category
			SubCategory savedSubCategory=subCategoryRepository.save(subCategory);
			return response.send("Sub Category Added!", savedSubCategory, HttpStatus.OK);
		}
	}

}
