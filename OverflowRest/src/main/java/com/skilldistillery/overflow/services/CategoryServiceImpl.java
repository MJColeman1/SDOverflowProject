package com.skilldistillery.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Category;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.respositories.CategoryRepository;
import com.skilldistillery.overflow.respositories.UserRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public Category getCategoryById(int categoryId) {
		return categoryRepo.findById(categoryId).get();
	}

//	COMMENTED OUT BECAUSE THERE IS A ALREADY A SHOW BY ID PATH IN CATEGORY CONTROLLER AND WE ARE CURRENTLY NOT USING THIS, KEEPING IN CASE WE CHANGE TO THIS METHOD INSTEAD
//	@Override
//	public Category getCategoryByName(String categoryName) {
//		return categoryRepo.findByNameIgnoreCase(categoryName);
//	}

	@Override
	public Category createNewCategory(int userId, String username, Category category) {
		User user = userRepo.findById(userId).get();
		
		if (user.getUsername().equals(username)) {
			return categoryRepo.saveAndFlush(category);
		}
		return null;
	}

	@Override
	public Category updateCategoryById(int userId, String username, int categoryId, Category category) {
		User user = userRepo.findById(userId).get();
		Category managedCategory = categoryRepo.findById(categoryId).get();
		
		if (user.getUsername().equals(username)) {
			managedCategory.setName(category.getName());
			managedCategory.setDescription(category.getDescription());
			
			return categoryRepo.saveAndFlush(managedCategory);
		}
		return null;
	}

	@Override
	public Boolean deleteCategoryById(int userId, String username, int categoryId) {
		System.out.println(userId+username+categoryId);
		Category category = categoryRepo.findById(categoryId).get();
		User user = userRepo.findById(userId).get();
		
		boolean deleted = false;
		try {
			if (user.getUsername().equals(username)) {
				if (category != null) {
					categoryRepo.deleteById(categoryId);
					deleted = true;
					return true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return deleted;
	}

}
