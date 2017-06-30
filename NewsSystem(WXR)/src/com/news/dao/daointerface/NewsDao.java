package com.news.dao.daointerface;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.news.pojo.News;


public interface NewsDao extends BaseDao<News>{
	/**
	 * 
	 * @return
	 */
	public List<News> findAllNews();

	/**
	 * @param id
	 * @return
	 */
	public News getNewsById(int id);
	/**
	 * @return
	 */
	public List<News> searchNewsByCategory(int totalSize,int currentPage, int pageSize,int categoryId);
	
	public List<News> getNewsPaging(int totalSize,int currentPage, int pageSize);
	//获取所有记录数
	public int getTotalSize();
	//通过categoryID获取新闻记录数
	public int getTotalSizeByCategoryId(int categoryId);
}
