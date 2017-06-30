/**
* @Title: NewsService.java
* @Package com.news.service
* @Description: TODO
* @author Lover
* @date 2017年6月12日
* @version V1.0
*/
package com.news.service;

import java.util.List;

import com.news.pojo.News;

/**
 * @author Lover
 * @date:日期：2017年6月12日
 */
public interface NewsService {
	public void addNews(News news);

	public void deleteNews(News news);

	public void updateNews(News news);

	public News queryNews(int id);

	/**
	 * @return
	 */
	public List<News> findAllNewses();
	
	public List<News> searchNewsByCategory(int totalSize, int currentPage, int pageSize,int categoryId);

	/**
	 * @param nid
	 * @return
	 */
	public News getNewsById(int nid);
	//获取新闻
	public List<News> getNewsPaging(int totalSize,int currentPage,int pageSize);
	//获取总页数
	public int  getTotalSize();
	//通过categoryID获取记录数
	public int  getTotalSizeByCategoryID(int categoryId);
}
