/**
* @Title: NewsDaoImpl.java
* @Package com.news.dao
* @Description: TODO
* @author Lover
* @date 2017年5月27日
* @version V1.0
*/
package com.news.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.news.dao.daointerface.NewsDao;
import com.news.pojo.News;

@Repository
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {
	/* 查询所有新闻
	 */
	@Override
	public List<News> findAllNews() {
		String hql="from News";
		Query query=getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<News> list=query.list();
		if (list!=null && list.size()>0) {
			return list;
		}
		return null;
	}
	/* 通过id查询新闻
	 */
	@Override
	public News getNewsById(int id) {
//		Category c=(Category) session.load(Category.class,id);
		String hql="from News where nid=?";
		Query query=getSessionFactory().getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		@SuppressWarnings("unchecked")
		List<News> list=query.list();
		if (list!=null && list.size()>0) {
			System.out.println("查找成功");
			return list.get(0);
			
		}
		return null;
	}

	/* 通过类型查询新闻
	 */
	@Override
	public List<News> searchNewsByCategory(int totalSize,int currentPage, int pageSize,int categoryId) {
		String hql="from News where categoryId="+categoryId;
		Query query=getSessionFactory().getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<News> list=query.list();
		if (list!=null && list.size()>0) {
			return list;
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<News> getNewsPaging(int totalSize,int currentPage, int pageSize) {
		Session session= getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		String hql="from News";
		Query query=session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<News> list=query.list();
		transaction.commit();
		session.close();
		return list;
	}

	@Override
	public int getTotalSize() {
		Session session= getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from News");
		int count=query.list().size();
		//System.out.println(count);
		transaction.commit();
		session.close();
		return count;
	}
	@Override
	public int getTotalSizeByCategoryId(int categoryId) {
		Session session= getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from News where categoryId="+categoryId);
		int count=query.list().size();
		System.out.println(count);
		transaction.commit();
		session.close();
		return count;
	}

}
