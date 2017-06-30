package com.news.dao.daointerface;
import java.util.List;
import com.news.pojo.Category;


public interface CategoryDao extends BaseDao<Category>{
	
	/**
	 * 
	 * @return
	 */
	public List<Category> findAllCategory();
	
}
