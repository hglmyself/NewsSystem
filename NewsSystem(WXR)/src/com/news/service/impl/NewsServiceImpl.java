package com.news.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.news.dao.daointerface.NewsDao;
import com.news.pojo.News;
import com.news.service.NewsService;


@Transactional(readOnly=false)
@Service("newsService")
public class NewsServiceImpl implements NewsService{
	@Resource private NewsDao newsDao;
	
	/**
	 * @return the newsDao
	 */
	public NewsDao getNewsDao() {
		return newsDao;
	}

	/**
	 * @param newsDao the newsDao to set
	 */
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	@Override
	public void addNews(News news) {
		newsDao.save(news);
	}

	@Override
	public void deleteNews(News news) {
		newsDao.delete(news);
	}
	
	@Override
	public void updateNews(News news) {
		newsDao.update(news);
	}

	@Override
	public News queryNews(int id) {
		News news=newsDao.getNewsById(id);
		return news;
	}
	@Override
	public News getNewsById(int id) {
		News news=newsDao.getNewsById(id);
		return news;
	}
	@Override
	public List<News> findAllNewses() {
		List<News> list = newsDao.findAllNews();
		return list;
	}

	@Override
	public List<News> searchNewsByCategory(int totalSize, int currentPage, int pageSize,int categoryId) {
		List<News> list = newsDao.searchNewsByCategory(totalSize,currentPage,pageSize,categoryId);
		return list;
	}
	@Override
	public List<News> getNewsPaging(int totalSize, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return newsDao.getNewsPaging(totalSize, currentPage, pageSize);
	}

	@Override
	public int getTotalSize() {
		// TODO Auto-generated method stub
		return newsDao.getTotalSize();
	}

	@Override
	public int getTotalSizeByCategoryID(int categoryId) {
		
		return newsDao.getTotalSizeByCategoryId(categoryId);
	}
	

}
