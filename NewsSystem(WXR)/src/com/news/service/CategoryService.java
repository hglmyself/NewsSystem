package com.news.service;

import java.util.List;

import com.news.pojo.Category;


public interface CategoryService {
	public void addCategory(Category category);

	public void deleteCategory(Category category);

	public void updateCategory(Category category);

	public Category queryCategory(int id);

	/**
	 * @return
	 */
	public List<Category> findAllCategories();

}
