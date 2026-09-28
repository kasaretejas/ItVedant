package com.tejas.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tejas.entities.Product;
import com.tejas.entities.SubCategory;
import com.tejas.entities.Vendor;
import com.tejas.repositories.ProductRepository;
import com.tejas.repositories.SubCategoryRepository;
import com.tejas.repositories.VendorRepository;
import com.tejas.response.UnivesalResponse;
import com.tejas.specifications.ProductSpecification;

import tools.jackson.databind.ObjectMapper;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SubCategoryRepository subCategoryRepository;   
	
	@Autowired
	UnivesalResponse response;
	
	private final String UPLOAD_DIR = System.getProperty("user.dir")+"/uploads/images";
	
	public ResponseEntity<?> addProduct(String productObject, MultipartFile image) throws IOException
	{
		//changing product object from string to product
		ObjectMapper objectMapper = new ObjectMapper();
		Product product=objectMapper.readValue(productObject, Product.class);
		
		//finding sub category
		int subCategoryId=product.getSubCategory().getId();
		SubCategory existingSubCategory=subCategoryRepository.findById(subCategoryId).get();
		product.setSubCategory(existingSubCategory);
		
		//upload image in uploads/images folder
		String originalImageName=image.getOriginalFilename();
		product.setImageName(originalImageName);
		Path completeImagePath=Paths.get(UPLOAD_DIR, originalImageName);
		Files.write(completeImagePath, image.getBytes());
		
		//saving product
		Product savedProduct=productRepository.save(product);
		return response.send("Product Added!", savedProduct, HttpStatus.CREATED);

	}
	
	
	@Autowired
	VendorRepository vendorRepository;
	public ResponseEntity<?> getAllProductsByVendorId(int vendorId)
	{
		Optional<Vendor> vendor=vendorRepository.findById(vendorId);
		if(vendor.isPresent())
		{
			List<Product> productsByVendor=productRepository.findAllByVendor(vendor.get());
			return response.send("Products added by you", productsByVendor, HttpStatus.FOUND);
		}
		else
		{
			return response.send("There are no products added by you", null, HttpStatus.NOT_FOUND);
		}
		
	}
	
	public boolean getProductByVendorIdAndProductId(int vendorId, int productId)
	{
		Optional<Vendor> vendor=vendorRepository.findById(vendorId);
		Optional<Product> productByVendor=productRepository.findByVendorAndId(vendor.get(), productId);
		if(vendor.isPresent() && productByVendor.isPresent())
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	public ResponseEntity<?> deleteProduct(int vendorId, int productId)
	{
		if(getProductByVendorIdAndProductId(vendorId, productId))
		{
			productRepository.deleteById(productId);
			return response.send("Product Deleted", true, HttpStatus.OK);

		}
		else
		{
			return response.send("Product Deletion failed", false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> getProductById(int productId)
	{
		Optional<Product> existingProduct=productRepository.findById(productId);
		if(existingProduct.isPresent())
		{
			return response.send("Follwoing product found", existingProduct.get(), HttpStatus.FOUND);
		}
		else
		{
			return response.send("Product Does not exists",null, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<?> updateProduct(int vendorId, int productId,String productObject, MultipartFile image) throws IOException
	{
		
		if(getProductByVendorIdAndProductId(vendorId,productId))
		{
			Product existingProduct=productRepository.findById(productId).get();
			//changing product object from string to product
			ObjectMapper objectMapper = new ObjectMapper();
			Product product=objectMapper.readValue(productObject, Product.class);
			
			//upload image in uploads/images folder
			String originalImageName=image.getOriginalFilename();
			Path completeImagePath=Paths.get(UPLOAD_DIR, originalImageName);
			Files.write(completeImagePath, image.getBytes());
			
			//saving product
			product.setId(existingProduct.getId()); //otherwise this product will be added as new product;
			product.setSubCategory(existingProduct.getSubCategory());//otherwise sub category will be set as null
			product.setImageName(originalImageName);
			product.setCreatedAt(existingProduct.getCreatedAt()); //otherwise created at will be set as null
			product.setVendor(existingProduct.getVendor()); //otherwise vendor id will be set as null
			Product savedProduct=productRepository.save(product);
			return response.send("Product Added!", savedProduct, HttpStatus.CREATED);
		}
		else
		{
			return response.send("Product Updation failed", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//CSTOMER POV
	public ResponseEntity<?> getAllProducts()
	{
		List<Product> products=productRepository.findAll();
		return response.send("Follwoing products found", products, HttpStatus.FOUND);
	}
	
	public ResponseEntity<?> filterProducts(String categoryName,String subCategoryName, String productName, String sortDirection, Integer minPrice, Integer maxPrice)
	{
		Specification<Product> allFilters=Specification.where(ProductSpecification.hasCategory(categoryName))
													.and(ProductSpecification.hasSubCategory(subCategoryName))
													.and(ProductSpecification.containsName(productName))
													.and(ProductSpecification.sortByPrice(sortDirection))
													.and(ProductSpecification.priceBetween(minPrice,maxPrice));
	
		 List<Product> filteredProducts=productRepository.findAll(allFilters);
		 
		 return response.send("Follwoing filtered products found", filteredProducts, HttpStatus.OK);
	}
	
}
















