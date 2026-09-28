package com.tejas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.entities.Product;
import com.tejas.entities.SubCategory;
import com.tejas.entities.Vendor;
import com.tejas.repositories.ProductRepository;
import com.tejas.repositories.SubCategoryRepository;
import com.tejas.repositories.VendorRepository;
import com.tejas.responsewrapper.CustomResponse;
import com.tejas.specifications.ProductSpecification;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	CustomResponse response;
	
	
	public ResponseEntity<CustomResponse> addProduct(Product product)
	{
		long subCategoryId = product.getSubCategory().getId();
		long vendorId =  product.getVendor().getId();
		if(subCategoryRepository.existsById(subCategoryId) && vendorRepository.existsById(vendorId))
		{
			SubCategory existingSubCategory=subCategoryRepository.findById(subCategoryId).get();
			Vendor existingVendor=vendorRepository.findById(vendorId).get();
			
			product.setSubCategory(existingSubCategory);
			product.setVendor(existingVendor);
			
			Product savedProduct=productRepository.save(product);
			
			response.setMessage("Product Added");
			response.setData(savedProduct);
			
			return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
			
		}
		else
		{
			response.setMessage("Either subcategory or vendor does not exists");
			response.setData(null);
			return new ResponseEntity<CustomResponse>(response, HttpStatus.NOT_FOUND);
		}
	}
	

	public ResponseEntity<CustomResponse> getFilteredProducts(String category)
	{
		Specification<Product> filtrationCriteria=Specification.where(ProductSpecification.hasCategory(category));
		List<Product> filteredProduct=productRepository.findAll(filtrationCriteria);
		response.setMessage("following products found");
		response.setData(filteredProduct);
		return new ResponseEntity(response,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
