package com.blueyonder.shopservice.service;

import java.util.List;

import com.blueyonder.shopservice.entity.Category;
import com.blueyonder.shopservice.exceptions.CategoryNotFoundException;

public interface CategoryService {
	public Category addCategory(Category category);
	public String deleteCategoryById(Integer categoryId) throws CategoryNotFoundException;
//	public Category updateCategoryById(Integer categoryId);
//	public Category updateCategoryByName(String categoryName);
	public Iterable<Category> ListAllCategory();
	public Category getCategoryById(Integer categoryId)throws CategoryNotFoundException;
	public Category getCategoryByName(String cname)throws CategoryNotFoundException;
	
	

}
