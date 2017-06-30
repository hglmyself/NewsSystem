/**
* @Title: NewsAction.java
* @Package com.news.action
* @Description: TODO
* @author Lover
* @date 2017年5月27日
* @version V1.0
*/
package com.news.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.news.pojo.News;
import com.news.service.NewsService;
import com.news.util.SplitPage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * @author Lover
 * @date:日期：2017年5月27日
 */
public class NewsAction extends ActionSupport{
	/**
	 * 定义变量
	 */
	private static final long serialVersionUID = 1L;
	private int nid;
	
	//配置分页
	//获取超链接传递过来的页码参数
	private int pno=1; //设置第一页
	
	private News news;
	//获取按照类型查询新闻的select值
	private int categoryName;
	//定义新闻集合
	private List<News> newList;
	//读取配置文件
	private ApplicationContext ac  
		= new ClassPathXmlApplicationContext("applicationContext.xml");
	//获取Service配置
	private NewsService newsService 
		= (NewsService) ac.getBean("newsService");
	//发布新闻
	public String addNews() throws Exception{	
		if (news.getUpload() != null) {		
			String filePath=news.getImage_path()+"\\"+news.getUploadFileName();
			/*System.out.println(filePath);
			System.out.println(news.getUpload());*/
			FileOutputStream os=new FileOutputStream(filePath);
			FileInputStream is=new FileInputStream(news.getUpload());
					
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) > 0) {
				os.write(buffer,0,len);
			}
			os.close();
			is.close();
			newsService.addNews(news);
			}
			return SUCCESS;
		}
	//获取新闻
	public String updateNews(){
//     	System.out.println("ABCDES"+nid);
	    news = newsService.queryNews(nid);
		return "update";
	}
	//更改新闻
	public String updatedNews(){
		newsService.updateNews(news);
		return SUCCESS;
	}
	//删除新闻
	public String deleteNews(){
		news = newsService.queryNews(nid);
		newsService.deleteNews(news);
		return SUCCESS;
	}
	//查询所有的新闻
	public String newsList(){
		newList = newsService.findAllNewses();
		return "list";
	}
	//按照类型查询新闻
	@SuppressWarnings("unchecked")
	public String SearchNewsByCategory(){
		//获取该新闻类型的总记录数
		int totalSize= newsService.getTotalSizeByCategoryID(categoryName);
		//声明分页控制对象
		SplitPage splitPage=new SplitPage(pno, totalSize);
		//返回分页的结果
		newList=newsService.searchNewsByCategory(totalSize, pno, splitPage.getPageSize(), categoryName);
		@SuppressWarnings("rawtypes")
		//通过map容器把控制分页的对象传到jsp页面
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("splitPage", splitPage);
		return "list";
	}
	//按照类型查询新闻
	@SuppressWarnings("unchecked")
	public String NewsByCategory(){
			//获取该新闻类型的总记录数
			int totalSize= newsService.getTotalSizeByCategoryID(categoryName);
			System.out.println("categoryName="+categoryName);
			//声明分页控制对象
			SplitPage splitPage=new SplitPage(pno, totalSize);
			//返回分页的结果
			newList=newsService.searchNewsByCategory(totalSize, pno, splitPage.getPageSize(), categoryName);
			@SuppressWarnings("rawtypes")
			//通过map容器把控制分页的对象传到jsp页面
			Map request=(Map) ActionContext.getContext().get("request");
			request.put("splitPage", splitPage);
			return "newsByCategory";
	}
	public String showNews(){
//		news=newsDao.getNewsById(id);
		news=newsService.getNewsById(nid);
		return "show";
	}
	//开始查询数据 实现分页显示
	@SuppressWarnings("unchecked")
	public String queryByPage() {
		//从数据的总记录数
		int totalSize= newsService.getTotalSize();
		//定义分页工具
		SplitPage splitPage=new SplitPage(pno, totalSize);
		//开始分类
		newList=newsService.getNewsPaging(totalSize,pno,splitPage.getPageSize());
		//把控制分页的对象传到jsp页面当中
		@SuppressWarnings("rawtypes")
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("splitPage", splitPage);
		return "list";
	}
	/**
	 * @return the pno
	 */
	public int getPno() {
		return pno;
	}
	/**
	 * @param pno the pno to set
	 */
	public void setPno(int pno) {
		this.pno = pno;
	}
	/**
	 * @return the categoryName
	 */
	public int getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(int categoryName) {

		this.categoryName = categoryName;
	}
	/**
	 * @return the nid
	 */
	public int getNid() {
		return nid;
	}
	/**
	 * @param nid the nid to set
	 */
	public void setNid(int nid) {
		this.nid = nid;
	}
	/**
	 * @return the news
	 */
	public News getNews() {
		return news;
	}
	/**
	 * @param news the news to set
	 */
	public void setNews(News news) {
		this.news = news;
	}
	/**
	 * @return the newList
	 */
	public List<News> getNewList() {
		return newList;
	}
	/**
	 * @param newList the newList to set
	 */
	public void setNewList(List<News> newList) {
		this.newList = newList;
	}
}
