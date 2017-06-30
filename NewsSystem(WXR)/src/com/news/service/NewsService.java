/**
* @Title: NewsService.java
* @Package com.news.service
* @Description: TODO
* @author Lover
* @date 2017��6��12��
* @version V1.0
*/
package com.news.service;

import java.util.List;

import com.news.pojo.News;

/**
 * @author Lover
 * @date:���ڣ�2017��6��12��
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
	//��ȡ����
	public List<News> getNewsPaging(int totalSize,int currentPage,int pageSize);
	//��ȡ��ҳ��
	public int  getTotalSize();
	//ͨ��categoryID��ȡ��¼��
	public int  getTotalSizeByCategoryID(int categoryId);
}
