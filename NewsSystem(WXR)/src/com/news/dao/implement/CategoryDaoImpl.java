/**
* @Title: CategoryDaoImpl.java
* @Package com.news.dao
* @Description: TODO
* @author Lover
* @date 2017�?�?4�?
* @version V1.0
*/
package com.news.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.news.dao.daointerface.CategoryDao;
import com.news.pojo.Category;


@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao{
	/* 
	 */
	@Override
	public List<Category> findAllCategory() {
		String hql="from Category";
		Query query=getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list=query.list();	
		if (list!=null && list.size()>0) {
			System.out.println(list.size());
			return list;
			
		}
		return null;
	}
}
