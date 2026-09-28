package com.tejas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long>
{
	boolean existsByName(String subCategoryName);
	List<SubCategory> findByUserId(long userId); // this method will return sub categories for specific user(vendor) only
}
