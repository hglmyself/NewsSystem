/**
* @Title: CategoryAction.java
* @Package com.news.action
* @Description: TODO
* @author Lover
* @date 2017��5��24��
* @version V1.0
*/
package com.news.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.news.pojo.Category;
import com.news.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lover
 * @date:���ڣ�2017��5��24��
 */
public class CategoryAction extends ActionSupport{
	/**
	 * �������
	 */
	private static final long serialVersionUID = 1L;
	private int cid;
	private Category category;
	//�����������͵ļ���
	private List<Category> categories;
	private List<Category> findCategory = new ArrayList<Category>();
	//��ȡ�����ļ�
	private ApplicationContext ac  
	= new ClassPathXmlApplicationContext("applicationContext.xml");
	//��ȡService����
	private CategoryService categoryService 
	= (CategoryService) ac.getBean("categoryService");
	
	/**
	 * @return the findCategory
	 */
	public List<Category> getFindCategory() {
		findCategory = categoryService.findAllCategories();
		//System.out.println(findCategory);
		return findCategory;
	}
	
	/**
	 * @param findCategory the findCategory to set
	 */
	public void setFindCategory(List<Category> findCategory) {
		this.findCategory = findCategory;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	//�������
	public String addCategory()
	{
		categoryService.addCategory(category);
		return SUCCESS;
	}
	//��ȡ�������
	public String categoryUpdate(){
//		System.out.println(cid);
		category = categoryService.queryCategory(cid);
		return "update";
	}
	//�������
	public String categoryUpdated(){
		categoryService.updateCategory(category);
		return SUCCESS;
	}
	//ɾ�����
	public String deleteCategory(){
		category = categoryService.queryCategory(cid);
		categoryService.deleteCategory(category);
		return SUCCESS;
	}
	//��ȡȫ���������
	public String listCategories(){
		categories = categoryService.findAllCategories();
		return "list";
	}
}
