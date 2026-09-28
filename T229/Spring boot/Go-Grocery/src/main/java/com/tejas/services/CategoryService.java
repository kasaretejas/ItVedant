package com.tejas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.custom_response.Response;
import com.tejas.entities.Category;
import com.tejas.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	Response response;
	
	public ResponseEntity<?> addCategory(Category category)
	{
		if(categoryRepository.existsByName(category.getName()))
		{
			return response.send("Category already exists!", null, HttpStatus.FOUND);
		}
		else
		{
			Category savedCategory=categoryRepository.save(category);
			return response.send("Category added", savedCategory, HttpStatus.OK);
		}
		
		
	}

	public ResponseEntity<?> getAllCategories()
	{
		List<Category> categories=categoryRepository.findAll();
		return response.send("Follwoing categories found", categories, HttpStatus.FOUND);
	}
}
