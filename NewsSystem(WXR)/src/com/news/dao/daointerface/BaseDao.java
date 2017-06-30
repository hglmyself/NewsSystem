package com.news.dao.daointerface;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

/**
 * ʵ��DAO����Ļ���
 * @param <T>
 *
 */
public interface BaseDao<T> {
	public void setMySessionFactory(SessionFactory sessionFactory);
	//����ID����ʵ��
	T get(Class<T> entity,Serializable id);
	//����ʵ��
	Serializable save(T entity);
	//����ʵ��
	void update(T entity);
	//ɾ��ʵ��
	void delete(T entity);
	/**
	 * @param hql
	 * @return
	 */
	public List find(String hql);
}
