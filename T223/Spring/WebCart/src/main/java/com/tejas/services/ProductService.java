package com.tejas.services;

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
import com.tejas.repositories.UserRepository;
import com.tejas.repositories.VendorRepository;
import com.tejas.response_wrapper.ResponseWrapper;
import com.tejas.response_wrapper.UniversalResponse;
import com.tejas.specifications.ProductSpecification;

import tools.jackson.databind.ObjectMapper;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	SubCategoryRepository subCategoryRepository;
	@Autowired
	VendorRepository vendorRepository;
	@Autowired
	UniversalResponse response;
	@Autowired
	UserRepository userRepository;
	
	
	//vendor side services
	private final String IMAGE_UPLOAD_DIR = System.getProperty("user.dir")+"/uploads/images";
	
	public ResponseEntity<ResponseWrapper> addProduct(String produtObject, MultipartFile productImage) throws IOException
	{
		//1. convert productObject which is in string into respective Product object
		ObjectMapper objectMapper = new ObjectMapper();
		Product product=objectMapper.readValue(produtObject, Product.class);
		
		//2.getting subcategory id and finding respective subcategory in table
		Optional<SubCategory> existingSubCategory=subCategoryRepository.findById(product.getSubCategory().getId());
		product.setSubCategory(existingSubCategory.get());
		
		//3.getting vendor id and finding respective vendor in table
		Optional<Vendor> existingVendor=vendorRepository.findById(product.getVendor().getId());
		product.setVendor(existingVendor.get());
		
		//4. save image in uploads/images folder and set image name into product object
		String originalImageName=productImage.getOriginalFilename();
		product.setImageName(originalImageName);
			//import java.nio.file.Path;
			//import java.nio.file.Paths;
		Path completeImagePath = Paths.get(IMAGE_UPLOAD_DIR, originalImageName);
		Files.write(completeImagePath, productImage.getBytes());
		
		//5.saving product
		Product savedProduct=productRepository.save(product);
		return response.send("Product added!", savedProduct, HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseWrapper> getProductsByVendor(Long vendorId)
	{
		//here vendorId is nothing but userId
		Optional<Vendor> existingVendor=vendorRepository.findById(vendorId);
		if(existingVendor.isPresent())
		{
			List<Product> products=productRepository.findAllByVendor(existingVendor.get());
			return response.send("Follwoing products found", products, HttpStatus.OK);
			
		}
		else
		{
			return response.send("Vendor Does not exists", null, HttpStatus.NOT_FOUND);
		}	
	}

	boolean getProductByVendorIdAndProductId(Long vendorId, Long productId)
	{
		Optional<Vendor> existingVendor=vendorRepository.findById(vendorId);
		if(existingVendor.isPresent())
		{
			Optional<Product> existingProduct=productRepository.findByVendorAndId(existingVendor.get(), productId);
			return existingProduct.isPresent();
		}
		else
		{
			return false;
		}
	}

	public ResponseEntity<ResponseWrapper> deleteProduct(Long vendorId, Long productId)
	{
		if(getProductByVendorIdAndProductId(vendorId,productId))
		{
			productRepository.deleteById(productId);
			return response.send("Product Deleted", null, HttpStatus.OK);
		}
		else
		{
			return response.send("Product not deleted!", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<ResponseWrapper> getProductById(Long vendorId, Long productId)
	{
		if(getProductByVendorIdAndProductId(vendorId,productId))
		{
			Product product=productRepository.findById(productId).get();
			return response.send("Following product found", product, HttpStatus.FOUND);
		}
		else
		{
			return response.send("Product not exists", null, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseWrapper> updateProduct(Long vendorId, Long productId, String produtObject, MultipartFile productImage) throws IOException
	{
		if(getProductByVendorIdAndProductId(vendorId,productId))
		{
			Product existingProduct=productRepository.findById(productId).get();
			
			//1. convert productObject which is in string into respective Product object
			ObjectMapper objectMapper = new ObjectMapper();
			Product newProduct=objectMapper.readValue(produtObject, Product.class);
			
			//2.getting subcategory id and finding respective subcategory in table
			Optional<SubCategory> existingSubCategory=subCategoryRepository.findById(newProduct.getSubCategory().getId());
			newProduct.setSubCategory(existingSubCategory.get());
			
			//3.getting vendor id and finding respective vendor in table
			newProduct.setVendor(existingProduct.getVendor());
			
			//4. save image in uploads/images folder and set image name into product object
			String originalImageName=productImage.getOriginalFilename();
			newProduct.setImageName(originalImageName);
				//import java.nio.file.Path;
				//import java.nio.file.Paths;
			Path completeImagePath = Paths.get(IMAGE_UPLOAD_DIR, originalImageName);
			Files.write(completeImagePath, productImage.getBytes());
			
			//5.created at value
			newProduct.setId(existingProduct.getId());
			newProduct.setCreatedAt(existingProduct.getCreatedAt());			
			//6.saving product
			Product savedProduct=productRepository.save(newProduct);
			return response.send("Product updated!", savedProduct, HttpStatus.OK);
			
		}
		else
		{
			//either vendor id or product id is not exists
			return response.send("Product cant update!", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//customer side services
	public ResponseEntity<ResponseWrapper> getAllProducts()
	{
		List<Product> products=productRepository.findAll();
		return response.send("Following products found", products, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseWrapper> getProductById(long productId)
	{
		Optional<Product> existingProduct=productRepository.findById(productId);
		if(existingProduct.isPresent())
		{
			return response.send("Following product found", existingProduct.get(), HttpStatus.OK);
		}
		else
		{
			return response.send("Product not found", null, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseWrapper> filterProducts(
			String categoryName,
			String subCategoryName,
			String sortDirection,
			String productName)
	{
		Specification<Product> productAllFilters=Specification.where(
				ProductSpecification.hasCategory(categoryName)
				.and(ProductSpecification.hasSubCategory(subCategoryName))
				.and(ProductSpecification.sortByPrice(sortDirection))
				.and(ProductSpecification.hasProductName(productName))
				);
		List<Product> filteredProducts=productRepository.findAll(productAllFilters);
		return response.send("Following products found", filteredProducts, HttpStatus.OK);
	}
	
}

















