package com.tejas.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.tejas.entities.Category;
import com.tejas.entities.Product;
import com.tejas.entities.SubCategory;

import jakarta.persistence.criteria.Join;

public class ProductSpecification 
{
	public static Specification<Product> hasCategory(String category)
	{
		return (root, query, criteriaBuilder)->
		{
			if(category==null || category.isBlank())
			{
				return null;
			}
			Join<Product, SubCategory> productSubcategoryJoin = root.join("subCategory");
			Join<SubCategory, Category> productCategoryJoin = productSubcategoryJoin.join("category");
			//criteriaBuilder.equal(productCategoryJoin.get("category"), category);
			return criteriaBuilder.equal(criteriaBuilder.lower(productCategoryJoin.get("name")), category.toLowerCase());
		};
	}
}
