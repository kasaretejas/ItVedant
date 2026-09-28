package com.tejas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.entities.Category;
import com.tejas.repositories.CategoryRepository;
import com.tejas.response.UnivesalResponse;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	UnivesalResponse response;
	
	public ResponseEntity<?> addCategory(Category category)
	{
		Category savedCategory=categoryRepository.save(category);
		return response.send("Follwoing Category Added", savedCategory, HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> getAllCategories()
	{
		List<Category> categories=categoryRepository.findAll();
		if(categories.size()>0)
		{
			return response.send("Follwoing Categories found", categories, HttpStatus.FOUND);
		}
		else
		{
			return response.send("There are no categors", null, HttpStatus.NOT_FOUND);
		}
		
	}

}










