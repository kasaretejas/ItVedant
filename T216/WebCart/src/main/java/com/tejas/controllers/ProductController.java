package com.tejas.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tejas.services.ProductService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@PostMapping("/vendor/products")
	public ResponseEntity<?> addProduct(@RequestPart("productObject")String productObject, @RequestParam("image")MultipartFile image) throws IOException
	{
		return productService.addProduct(productObject, image);
	}
	
	@GetMapping("/vendor/products/{vendorId}")
	public ResponseEntity<?> getAllProductsByVendorId(@PathVariable("vendorId") int vendorId)
	{
		return productService.getAllProductsByVendorId(vendorId);
	}
	
	@DeleteMapping("/vendor/products/{vendorId}/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable("vendorId")int vendorId, @PathVariable("productId") int productId)
	{
		return productService.deleteProduct(vendorId,productId);
	}
	
	@GetMapping("/vendor/product-by-id/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable("productId") int productId)
	{
		return productService.getProductById(productId);
	}
	
	@PutMapping("/vendor/products/{vendorId}/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable("vendorId") int vendorId, 
										   @PathVariable("productId") int productId,
										   @RequestPart("productObject")String productObject, 
										   @RequestParam("image") MultipartFile image) throws IOException
	{
		return productService.updateProduct(vendorId, productId, productObject, image);
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<?> publicgetProductById(@PathVariable("productId") int productId)
	{
		return productService.getProductById(productId);
	}
	
	@GetMapping("/products/filter") //you can use this maaping instead of above /products mapping to get all products
	public ResponseEntity<?> filterProducts(
			@RequestParam(required = false) String categoryName, 
			@RequestParam(required = false) String subCategoryName,
			@RequestParam(required = false) String productName,
			@RequestParam(required = false) String sortDirection,
			@RequestParam(required = false) Integer minPrice,
			@RequestParam(required = false) Integer maxPrice)
	{
		return productService.filterProducts(categoryName,subCategoryName,productName,sortDirection,minPrice,maxPrice);
	}


}
