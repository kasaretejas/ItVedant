package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.Product;
import com.tejas.responsewrapper.CustomResponse;
import com.tejas.services.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@PostMapping("/vendor/products")
	public ResponseEntity<CustomResponse> addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	
	@GetMapping("/get/products")
	public ResponseEntity<CustomResponse> getFilteredProducts(@RequestParam(name = "category",required = false)
	String category)
	{
		return productService.getFilteredProducts(category);
	}
}









