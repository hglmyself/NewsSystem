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
	// ����ID����ʵ��
	public T get(Class<T> entityClazz, Serializable id) {
		return (T) getHibernateTemplate().get(entityClazz, id);
	}

	// ����ʵ��
	public Serializable save(T entity) {
		return getHibernateTemplate().save(entity);
	}

	// ����ʵ��
	public void update(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	// ɾ��ʵ��
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}
	@Override
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	//��ѯҪ��ҳ�����ݱ�
	@Override
	public List find(String hql) {
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		List list = query.list();
		return list;
	}
	
}
