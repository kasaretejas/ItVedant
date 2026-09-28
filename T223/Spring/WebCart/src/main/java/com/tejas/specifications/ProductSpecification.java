package com.tejas.specifications;

import org.springframework.data.jpa.domain.Specification;
import com.tejas.entities.Category;
import com.tejas.entities.Product;
import com.tejas.entities.SubCategory;

import jakarta.persistence.criteria.Join;

public class ProductSpecification 
{
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
				Join<Product, SubCategory> productSubcategoryJoin =root.join("subCategory");
				Join<SubCategory, Category> productCategoryJoin=productSubcategoryJoin.join("category");
				return cb.equal(cb.lower(productCategoryJoin.get("name")), categoryName.toLowerCase());
			}
		};
	}
	
	public static Specification<Product> hasSubCategory(String subCategoryName)
	{
		return (root, query, cb)->
		{
			if(subCategoryName==null || subCategoryName.isBlank())
			{
				return null;
			}
			else
			{
				Join<Product, SubCategory> productSubcategoryJoin =root.join("subCategory");
				return cb.equal(cb.lower(productSubcategoryJoin.get("name")), subCategoryName.toLowerCase());
			}
		};
	}
	
	public static Specification<Product> sortByPrice(String sortDirection)
	{
		return (root, query, cb)->
		{
			if(sortDirection==null || sortDirection.isBlank())
			{
				return null;
			}
			if(sortDirection.equalsIgnoreCase("asc"))
			{
				 query.orderBy(cb.asc(root.get("price")));
			}
			else
			{
				query.orderBy(cb.desc(root.get("price")));
			}
			return null;
		};
	}
	
	public static Specification<Product> hasProductName(String productName)
	{
		return (root, query, cb)->
		{
			if(productName==null || productName.isBlank())
			{
				return null;
			}
			return cb.like(cb.lower(root.get("name")), "%"+productName.toLowerCase()+"%");
		};
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	