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
	//��ȡ���м�¼��
	public int getTotalSize();
	//ͨ��categoryID��ȡ���ż�¼��
	public int getTotalSizeByCategoryId(int categoryId);
}
