package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Category;

public interface CategoryService {
	
	List<Category> getAllCategories();
	
	Category getCategoryById(int categoryId);
	
//	Category getCategoryByName(String categoryName);
	
	Category createNewCategory(int userId, String username, Category category);
	
	Category updateCategoryById(int userId, String username, int categoryId, Category category);
	
	Boolean deleteCategoryById(int userId, String username, int categoryId);

}
