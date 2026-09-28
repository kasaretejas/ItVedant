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
import com.tejas.repositories.VendorRepository;
import com.tejas.response_wrapper.UnivarsalResponse;
import com.tejas.specifications.ProductSpecification;

import tools.jackson.databind.ObjectMapper;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	UnivarsalResponse response;
	
	private final String IMAGE_UPLOAD_DIR=System.getProperty("user.dir")+"/uploads/images";
	
	public ResponseEntity<?> addProduct(String productObject, MultipartFile productImage) throws IOException
	{
		//1. convert productObject from String to Product
			ObjectMapper objectMapper = new ObjectMapper();
			Product product = objectMapper.readValue(productObject, Product.class);
			
		//2. set subcategory to product (FK)
			Optional<SubCategory>  existingSubCategory=subCategoryRepository.findById(product.getSubCategory().getId());
			product.setSubCategory(existingSubCategory.get());	
			
		//3. set vendor to product (FK)
			Optional<Vendor>  existingVendor=vendorRepository.findById(product.getVendor().getId());
			product.setVendor(existingVendor.get());
			
		//4. set image name to product
			String originalImageName=productImage.getOriginalFilename();
			product.setImageName(originalImageName);
			
		//5. save image to images folder created by us
			Path completeImagePath=Paths.get(IMAGE_UPLOAD_DIR,originalImageName);
			Files.write(completeImagePath, productImage.getBytes());
			
		//6. store product into table
			Product savedProduct=productRepository.save(product);
			return response.send("Product Added!", savedProduct, HttpStatus.OK);
		
	}
	
	public ResponseEntity<?> getProductsByVendor(long vendorId)
	{
		List<Product> products=productRepository.findAllByVendorId(vendorId);
		if(products.size()==0)
		{
			return response.send("There are no products added by you!", null, HttpStatus.NOT_FOUND);
		}
		else
		{
			return response.send("Following products found", products, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<?> deleteProductByVendor(long vendorId, long productId)
	{
	   Optional<Product> existingProduct=productRepository.findByVendorIdAndId(vendorId, productId);
	   if(existingProduct.isPresent())
	   {
		   productRepository.deleteById(productId);
		   return response.send("Product deleted!", null, HttpStatus.OK); 
	   }
	   else
	   {
		   return response.send("Product or Vendor does not exists!", null, HttpStatus.NOT_FOUND); 
	   }
	}
	
	public ResponseEntity<?> getProductByVendor(long vendorId, long productId)
	{
		Optional<Product> existingProduct=productRepository.findByVendorIdAndId(vendorId, productId);
		   if(existingProduct.isPresent())
		   {
			   return response.send("Product deleted!", existingProduct.get(), HttpStatus.OK); 
		   }
		   else
		   {
			   return response.send("Product or Vendor does not exists!", null, HttpStatus.NOT_FOUND); 
		   }
	}
	
	public ResponseEntity<?> updateProductByVendor(long vendorId, long productId,String productObject, MultipartFile productImage) throws IOException
	{
		Optional<Product> optionalProduct=productRepository.findByVendorIdAndId(vendorId, productId);
		
		   if(optionalProduct.isPresent())
		   {
			   Product existingProduct=productRepository.findById(productId).get();
			 //1. convert productObject from String to Product
				ObjectMapper objectMapper = new ObjectMapper();
				Product newProduct = objectMapper.readValue(productObject, Product.class);
				
			//2. set subcategory to existingProduct (FK)
				Optional<SubCategory>  existingSubCategory=subCategoryRepository.findById(newProduct.getSubCategory().getId());
				newProduct.setSubCategory(existingSubCategory.get());	
				
			//3. set vendor to product (FK)
				newProduct.setVendor(existingProduct.getVendor());
				
			//4. set image name to product
				String originalImageName=productImage.getOriginalFilename();
				newProduct.setImageName(originalImageName);
				
			//5. save image to images folder created by us
				Path completeImagePath=Paths.get(IMAGE_UPLOAD_DIR,originalImageName);
				Files.write(completeImagePath, productImage.getBytes());
				
			//6. setting id of existing product to new product object
				newProduct.setId(existingProduct.getId());
			
			//7. setting createdAt of existing product to new product object
				newProduct.setCreatedAt(existingProduct.getCreatedAt());
				
			//8. store product into table
				Product updatedProduct=productRepository.save(newProduct);
				return response.send("Product Added!", updatedProduct, HttpStatus.OK);

		   }
		   else
		   {
			   return response.send("Product or Vendor does not exists!", null, HttpStatus.NOT_FOUND); 
		   }
	}
	
	
	//customer side products apis
	
	public ResponseEntity<?> getAllProducts()
	{
		List<Product> products=productRepository.findAll();
		return response.send("Following proucts found", products, HttpStatus.OK);
	}
	
	public ResponseEntity<?> filterProducts(String categoryName, String subCategoryName, String sortDirection,String productName)
	{
		Specification<Product> allCustomFiltersOnProduct=
				Specification.where(
						ProductSpecification.hasCategory(categoryName)
						.and(ProductSpecification.hasSubCategory(subCategoryName))
						.and(ProductSpecification.sortByPrice(sortDirection))
						.and(ProductSpecification.searchByProductName(productName)));
		
		List<Product> filteredProducts=productRepository.findAll(allCustomFiltersOnProduct);
		return response.send("following filtered products found", filteredProducts, HttpStatus.OK);
	}
}




















