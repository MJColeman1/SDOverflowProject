package com.skilldistillery.overflow.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.overflow.entities.Category;
import com.skilldistillery.overflow.services.CategoryService;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	private String username = "jackson";

	@RequestMapping(path = "/categories", method = RequestMethod.GET)
	public List<Category> index() {
		return categoryService.getAllCategories();
	}
	
	@RequestMapping(path = "/categories/{cid}", method = RequestMethod.GET)
	public Category showById(@PathVariable int cid) {
		return categoryService.getCategoryById(cid);
	}
	
	@RequestMapping(path = "/user/{userId}/categories", method = RequestMethod.POST)
	public Category create(@PathVariable int userId, @RequestBody Category category, HttpServletResponse res) {
		if (categoryService.createNewCategory(userId, username, category) == null) {
			res.setStatus(400);
			return null;
		}
		res.setStatus(201);
		return categoryService.createNewCategory(userId, username, category);
	}
	
	@RequestMapping(path = "/user/{userId}/categories/{cid}", method = RequestMethod.PUT)
	public Category update(@PathVariable int userId, @PathVariable int cid, @RequestBody Category category, HttpServletResponse res) {
		if (categoryService.updateCategoryById(userId, username, cid, category) == null) {
			res.setStatus(400);
			return null;
		}
		res.setStatus(200);
		return categoryService.updateCategoryById(userId, username, cid, category);
	}
	
	@RequestMapping(path = "/user/{userId}/categories/{cid}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable int userId, @PathVariable int cid, HttpServletResponse res) {
		if (categoryService.deleteCategoryById(userId, username, cid)) {
			res.setStatus(200);
			return true;
		}
		res.setStatus(400);
		return false;
	}

}
