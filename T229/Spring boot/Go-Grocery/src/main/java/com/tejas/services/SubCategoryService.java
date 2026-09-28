package com.tejas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.custom_response.CustomResponse;
import com.tejas.custom_response.Response;
import com.tejas.entities.Category;
import com.tejas.entities.SubCategory;
import com.tejas.entities.User;
import com.tejas.repositories.CategoryRepository;
import com.tejas.repositories.SubCategoryRepository;
import com.tejas.repositories.UserRepository;

@Service
public class SubCategoryService 
{
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Response response;
	
	public ResponseEntity<CustomResponse> addSubCategory(SubCategory subCategory)
	{
		if(subCategoryRepository.existsByName(subCategory.getName()))
		{
			return response.send("SubCategory already exists", null, HttpStatus.FOUND);
		}
		else
		{
			Category existingCategory=categoryRepository.findById(subCategory.getCategory().getId()).get();
			subCategory.setCategory(existingCategory); //in sub_category table FK of category will be added in category_id column
			
			User existingUser=userRepository.findById(subCategory.getUser().getId()).get();
			subCategory.setUser(existingUser);//in sub_category table FK of user will be added in user_id column
			
			SubCategory savedSubCategory=subCategoryRepository.save(subCategory);
			return response.send("SubCategory added", savedSubCategory, HttpStatus.OK);
		}
		
	}
	
	public ResponseEntity<CustomResponse> getSubcategoriesByVendor(long userId)
	{
		List<SubCategory> subCategories=subCategoryRepository.findByUserId(userId);
		return response.send("following SubCategory found", subCategories, HttpStatus.OK);
	}
}






















