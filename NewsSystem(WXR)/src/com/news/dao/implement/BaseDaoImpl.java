package com.news.dao.implement;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.news.dao.daointerface.BaseDao;

@Repository
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	// 根据ID加载实体
	public T get(Class<T> entityClazz, Serializable id) {
		return (T) getHibernateTemplate().get(entityClazz, id);
	}

	// 保存实体
	public Serializable save(T entity) {
		return getHibernateTemplate().save(entity);
	}

	// 更新实体
	public void update(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	// 删除实体
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}
	@Override
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	//查询要分页的数据表
	@Override
	public List find(String hql) {
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		List list = query.list();
		return list;
	}
	
}
