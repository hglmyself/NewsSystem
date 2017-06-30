/**
* @Title: NewsAction.java
* @Package com.news.action
* @Description: TODO
* @author Lover
* @date 2017��5��27��
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
 * @date:���ڣ�2017��5��27��
 */
public class NewsAction extends ActionSupport{
	/**
	 * �������
	 */
	private static final long serialVersionUID = 1L;
	private int nid;
	
	//���÷�ҳ
	//��ȡ�����Ӵ��ݹ�����ҳ�����
	private int pno=1; //���õ�һҳ
	
	private News news;
	//��ȡ�������Ͳ�ѯ���ŵ�selectֵ
	private int categoryName;
	//�������ż���
	private List<News> newList;
	//��ȡ�����ļ�
	private ApplicationContext ac  
		= new ClassPathXmlApplicationContext("applicationContext.xml");
	//��ȡService����
	private NewsService newsService 
		= (NewsService) ac.getBean("newsService");
	//��������
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
	//��ȡ����
	public String updateNews(){
//     	System.out.println("ABCDES"+nid);
	    news = newsService.queryNews(nid);
		return "update";
	}
	//��������
	public String updatedNews(){
		newsService.updateNews(news);
		return SUCCESS;
	}
	//ɾ������
	public String deleteNews(){
		news = newsService.queryNews(nid);
		newsService.deleteNews(news);
		return SUCCESS;
	}
	//��ѯ���е�����
	public String newsList(){
		newList = newsService.findAllNewses();
		return "list";
	}
	//�������Ͳ�ѯ����
	@SuppressWarnings("unchecked")
	public String SearchNewsByCategory(){
		//��ȡ���������͵��ܼ�¼��
		int totalSize= newsService.getTotalSizeByCategoryID(categoryName);
		//������ҳ���ƶ���
		SplitPage splitPage=new SplitPage(pno, totalSize);
		//���ط�ҳ�Ľ��
		newList=newsService.searchNewsByCategory(totalSize, pno, splitPage.getPageSize(), categoryName);
		@SuppressWarnings("rawtypes")
		//ͨ��map�����ѿ��Ʒ�ҳ�Ķ��󴫵�jspҳ��
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("splitPage", splitPage);
		return "list";
	}
	//�������Ͳ�ѯ����
	@SuppressWarnings("unchecked")
	public String NewsByCategory(){
			//��ȡ���������͵��ܼ�¼��
			int totalSize= newsService.getTotalSizeByCategoryID(categoryName);
			System.out.println("categoryName="+categoryName);
			//������ҳ���ƶ���
			SplitPage splitPage=new SplitPage(pno, totalSize);
			//���ط�ҳ�Ľ��
			newList=newsService.searchNewsByCategory(totalSize, pno, splitPage.getPageSize(), categoryName);
			@SuppressWarnings("rawtypes")
			//ͨ��map�����ѿ��Ʒ�ҳ�Ķ��󴫵�jspҳ��
			Map request=(Map) ActionContext.getContext().get("request");
			request.put("splitPage", splitPage);
			return "newsByCategory";
	}
	public String showNews(){
//		news=newsDao.getNewsById(id);
		news=newsService.getNewsById(nid);
		return "show";
	}
	//��ʼ��ѯ���� ʵ�ַ�ҳ��ʾ
	@SuppressWarnings("unchecked")
	public String queryByPage() {
		//�����ݵ��ܼ�¼��
		int totalSize= newsService.getTotalSize();
		//�����ҳ����
		SplitPage splitPage=new SplitPage(pno, totalSize);
		//��ʼ����
		newList=newsService.getNewsPaging(totalSize,pno,splitPage.getPageSize());
		//�ѿ��Ʒ�ҳ�Ķ��󴫵�jspҳ�浱��
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
