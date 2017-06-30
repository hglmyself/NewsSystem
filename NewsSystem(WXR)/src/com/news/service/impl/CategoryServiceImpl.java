package com.news.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.news.dao.daointerface.CategoryDao;
import com.news.pojo.Category;
import com.news.service.CategoryService;

@Transactional(readOnly=false)
@Service("categoryService")
public class CategoryServiceImpl  implements CategoryService{
	@Resource private CategoryDao categoryDao;
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public void addCategory(Category category) {
		categoryDao.save(category);		
	}

	public void deleteCategory(Category category) {
		categoryDao.delete(category);
	}

	public void updateCategory(Category category) {
		categoryDao.update(category);
	}

	public Category queryCategory(int id) {
		return categoryDao.get(Category.class, id);
	}
	
	@Override
	public List<Category> findAllCategories() {
		List<Category> list = categoryDao.findAllCategory();
		return list;
	}
	
}
