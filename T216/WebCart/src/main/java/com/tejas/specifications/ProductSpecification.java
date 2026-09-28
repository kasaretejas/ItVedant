package com.tejas.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.tejas.entities.Category;
import com.tejas.entities.Product;
import com.tejas.entities.SubCategory;

import jakarta.persistence.criteria.Join;

public class ProductSpecification 
{
	public static Specification<Product> hasSubCategory(String subCategoryName)
	{
		return (root, query, cb)-> //root:root table-product, query:sql query, criteria builder:like, between, lower
		{
			if(subCategoryName==null || subCategoryName.isBlank())
			{
				return null;    
			}
			else
			{
				// Join Product → SubCategory
	            Join<Product, SubCategory> productSubCategoryJoin = root.join("subCategory");
	            
	            // Filter by sub category (e.g. "formal", "sports")
	            return cb.equal(cb.lower(productSubCategoryJoin.get("name")), subCategoryName.toLowerCase());
			}
		};	
	}

	public static Specification<Product> hasCategory(String categoryName)
	{
		return (root, query, cb)-> 
		{
			if(categoryName==null || categoryName.isBlank())
			{
				return null;    
			}
			else
			{
				// Join Product → SubCategory
	            Join<Product, SubCategory> productSubCategoryJoin = root.join("subCategory");
	            
	            // Join SubCategory → Category
	            Join<SubCategory, Category> productCategoryJoin = productSubCategoryJoin.join("category");
	            
	            // Filter by category (e.g. "watch", "shoes","pants")
	            return cb.equal(cb.lower(productCategoryJoin.get("name")), categoryName.toLowerCase());
			}
		};	
	}
	
	public static Specification<Product> containsName(String productName)
	{
		return (root, query, cb) ->
		productName==null? null : cb.like(cb.lower(root.get("name")),"%" + productName.toLowerCase() +"%"); 
	}
	
	public static Specification<Product> sortByPrice(String sortDirection)
	{
		return (root, query, criteriaBuilder)->
		{
			if(sortDirection==null || sortDirection.isBlank())
			{
				return null;
			}
			if(sortDirection.equalsIgnoreCase("asc"))
			{
				 query.orderBy(criteriaBuilder.asc(root.get("price")));
			}
			else 
			{
				 query.orderBy(criteriaBuilder.desc(root.get("price")));
			}
			return null;
			
		};
	}
	
	public static Specification<Product> priceBetween(Integer minPrice, Integer maxPrice)
	{
		return (root, query, criteriaBuilder)->
		{
			if(minPrice==null && maxPrice==null)
			{
				return null;
			}
			if (minPrice != null && maxPrice != null) {
	            return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
	        }

	        if (minPrice != null) {
	            return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
	        }

	        if (maxPrice != null) {
	            return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
	        }

	        return null; // no filtering
			
		};
	}
	
	
}














