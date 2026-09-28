package com.tejas.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping("/vendor/products")
	public ResponseEntity<?> addProduct(@RequestPart("productObject") String productObject, 
			@RequestParam("productImage") MultipartFile productImage) throws IOException
	{
		return productService.addProduct(productObject, productImage);
	}
	
	@GetMapping("/vendor/products/{vendorId}")
	public ResponseEntity<?> getProductsByVendor(@PathVariable("vendorId") long vendorId)
	{
		return productService.getProductsByVendor(vendorId);
	}
	
	@DeleteMapping("/vendor/{vendorId}/products/{productId}")
	public ResponseEntity<?> deleteProductByVendor(@PathVariable("vendorId") long vendorId, @PathVariable("productId") long productId)
	{
		return productService.deleteProductByVendor(vendorId, productId);
	}
	
	@GetMapping("/vendor/{vendorId}/products/{productId}")
	public ResponseEntity<?> getProductByVendor(@PathVariable("vendorId") long vendorId, @PathVariable("productId") long productId)
	{
		return productService.getProductByVendor(vendorId, productId);
	}
	
	@PutMapping("/vendor/{vendorId}/products/{productId}")
	public ResponseEntity<?> updateProductByVendor(
			@PathVariable("vendorId") long vendorId, 
			@PathVariable("productId") long productId,
			@RequestPart("productObject") String productObject, 
			@RequestParam("productImage") MultipartFile productImage) throws IOException
	{
		return productService.updateProductByVendor(vendorId, productId, productObject, productImage);
	}
	
	
	//customer side products apis
	@GetMapping("/get/products")
	public ResponseEntity<?> getAllProducts()	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/get/filtered-products")
	public ResponseEntity<?> filterProducts(
			@RequestParam(name="categoryName",required = false) String categoryName,
			@RequestParam(name="subCategoryName",required = false)String subCategoryName,
			@RequestParam(name="sortDirection",required = false) String sortDirection,
			@RequestParam(name="productName",required = false) String productName)
	{
		return productService.filterProducts(categoryName, subCategoryName, sortDirection,productName);
	}

	
	
	
	
	
	
	
	

}
