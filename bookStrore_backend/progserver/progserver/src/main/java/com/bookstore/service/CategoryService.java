package com.bookstore.service;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.bookstore.entity.Category;



public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public void deleteCategory(Long categoryId);
	
	public Category getCategory(Long categoryId);
	
	public Set<Category> getCategories();
	
}
