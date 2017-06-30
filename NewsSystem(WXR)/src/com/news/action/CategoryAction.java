/**
* @Title: CategoryAction.java
* @Package com.news.action
* @Description: TODO
* @author Lover
* @date 2017年5月24日
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
 * @date:日期：2017年5月24日
 */
public class CategoryAction extends ActionSupport{
	/**
	 * 定义变量
	 */
	private static final long serialVersionUID = 1L;
	private int cid;
	private Category category;
	//定义新闻类型的集合
	private List<Category> categories;
	private List<Category> findCategory = new ArrayList<Category>();
	//读取配置文件
	private ApplicationContext ac  
	= new ClassPathXmlApplicationContext("applicationContext.xml");
	//获取Service配置
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

	//添加类型
	public String addCategory()
	{
		categoryService.addCategory(category);
		return SUCCESS;
	}
	//获取更新类别
	public String categoryUpdate(){
//		System.out.println(cid);
		category = categoryService.queryCategory(cid);
		return "update";
	}
	//更新类别
	public String categoryUpdated(){
		categoryService.updateCategory(category);
		return SUCCESS;
	}
	//删除类别
	public String deleteCategory(){
		category = categoryService.queryCategory(cid);
		categoryService.deleteCategory(category);
		return SUCCESS;
	}
	//获取全部新闻类别
	public String listCategories(){
		categories = categoryService.findAllCategories();
		return "list";
	}
}
