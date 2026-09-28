package com.tejas.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.tejas.entities.Category;
import com.tejas.entities.Product;
import com.tejas.entities.SubCategory;

import jakarta.persistence.criteria.Join;

public class ProductSpecification {
	//category wise filtration
	public static Specification<Product> hasCategory(String categoryName)
	{
		return (root,query,criteriaBuilder) -> 
		 {
			if(categoryName == null || categoryName.isBlank())
			{
				return null;
			}
			Join<Product, SubCategory> productSubCategoryJoin = root.join("subCategory");
			Join<SubCategory, Category> productCategoryJoin = productSubCategoryJoin.join("category");
			return criteriaBuilder.equal(criteriaBuilder.lower(productCategoryJoin.get("name")),categoryName.toLowerCase());
		 };

	}
	//sub category wise filtration
	public static Specification<Product> hasSubCategory(String subCategoryName)
	{
		return (root,query,criteriaBuilder) -> 
		 {
			if(subCategoryName == null || subCategoryName.isBlank())
			{
				return null;
			}
			Join<Product, SubCategory> productSubCategoryJoin = root.join("subCategory");
			return criteriaBuilder.equal(criteriaBuilder.lower(productSubCategoryJoin.get("name")),subCategoryName.toLowerCase());
		 };

	}
	//sort by price : 
	//we make specifications for filtration. but when we do sorting, we are not technically filtering any data
	//every specification method return predicate after filtering record
	public static Specification<Product> sortByPrice(String sortDirection) //sort direction has values : asc or desc
	{
		return (root,query,criteriaBuilder) -> 
		 {
			if(sortDirection == null || sortDirection.isBlank())
			{
				return null;
			}
			
			//code for sort
			  if (sortDirection.equalsIgnoreCase("asc")) 
			  {
		           query.orderBy(criteriaBuilder.asc(root.get("price")));
		       } 
			  else if (sortDirection.equalsIgnoreCase("desc")) 
			  {
		            query.orderBy(criteriaBuilder.desc(root.get("price")));
		       }
			  return null; //here we are return null, that means we are not applying any filter
		 };

	}
	//search by product name
	public static Specification<Product> searchByProductName(String productName) 
	{
		return (root,query,criteriaBuilder) -> 
		 {
			if(productName == null || productName.isBlank())
			{
				return null;
			}
			
			//code for search
			return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%"+productName.toLowerCase()+"%");  
		 };
	}

}


















