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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tejas.entities.Vendor;
import com.tejas.repositories.ProductRepository;
import com.tejas.response_wrapper.ResponseWrapper;
import com.tejas.services.ProductService;

	@RestController
	@RequestMapping("/api/v1")
	@CrossOrigin("*")
	public class ProductController {
		
		@Autowired
		ProductService productService;
		
		@PostMapping("/vendor/products")
		public ResponseEntity<?> addProduct(@RequestPart("productObject")String productObject, 
											@RequestParam("productImage")MultipartFile image) throws IOException
		{
			return productService.addProduct(productObject, image);
		}
		
		@GetMapping("/vendor/{vendorId}/products")
		public ResponseEntity<ResponseWrapper> getProductsByVendor(@PathVariable("vendorId") Long vendorId)
		{
			return productService.getProductsByVendor(vendorId);
		}
		
		@DeleteMapping("/vendor/{vendorId}/products/{productId}")
		public ResponseEntity<ResponseWrapper> deleteProduct(@PathVariable("vendorId") Long vendorId, @PathVariable("productId")Long productId)
		{
			return productService.deleteProduct(vendorId,productId);
		}
		
		
		@GetMapping(("/vendor/{vendorId}/products/{productId}"))
		public ResponseEntity<ResponseWrapper> getProductById(@PathVariable("vendorId") Long vendorId, @PathVariable("productId")Long productId)
		{
			return productService.getProductById(vendorId, productId);
		}
		
		
		@PutMapping("/vendor/{vendorId}/products/{productId}")
		public ResponseEntity<ResponseWrapper> updateProduct(
				@PathVariable("vendorId") Long vendorId, 
				@PathVariable("productId") Long productId, 
				@RequestPart("productObject") String produtObject, 
				@RequestParam("productImage") MultipartFile productImage ) throws IOException
		{
			return productService.updateProduct(vendorId, productId, produtObject, productImage);
		}

		//customer side controllers
		//@GetMapping("/products")
		@GetMapping("/get/products")
		public ResponseEntity<ResponseWrapper> getAllProducts()
		{
			return productService.getAllProducts();
		}
		
		//@GetMapping("/products/{id}")
		@GetMapping("/get/products/{id}")
		public ResponseEntity<ResponseWrapper> getProductById(@PathVariable("id") long productId)
		{
			return productService.getProductById(productId);
		}
		
		//@GetMapping("/products/filter")
		@GetMapping("/filter")
		public ResponseEntity<ResponseWrapper> filterProducts(
				@RequestParam(value = "categoryName",required = false) String categoryName, 
				@RequestParam(value = "subCategoryName",required = false)String subCategoryName,
				@RequestParam(value = "sortDirection",required = false) String sortDirection,
				@RequestParam(value = "productName",required = false) String productName)
		{
			return productService.filterProducts(categoryName,subCategoryName,sortDirection,productName);
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
