package com.tejas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.entities.Category;
import com.tejas.repositories.CategoryRepository;
import com.tejas.response_wrapper.UnivarsalResponse;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	UnivarsalResponse response;
	
	public ResponseEntity<?> getAllCategories()
	{
		List<Category> categories=categoryRepository.findAll();
		return response.send("follwing categories found", categories, HttpStatus.OK);
	}
	
	public ResponseEntity<?> addCategory(Category category)
	{
		if(categoryRepository.existsByNameIgnoreCase(category.getName()))
		{
			return response.send(category.getName()+" is alredy exists", null, HttpStatus.FOUND);
		}
		else
		{
			Category savedCategory=categoryRepository.save(category);
			return response.send("following category added", savedCategory, HttpStatus.OK);
		}
	}
}



