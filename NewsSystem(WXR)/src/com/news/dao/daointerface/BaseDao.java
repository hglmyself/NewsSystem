package com.news.dao.daointerface;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

/**
 * 实现DAO组件的基类
 * @param <T>
 *
 */
public interface BaseDao<T> {
	public void setMySessionFactory(SessionFactory sessionFactory);
	//根据ID加载实体
	T get(Class<T> entity,Serializable id);
	//保存实体
	Serializable save(T entity);
	//更新实体
	void update(T entity);
	//删除实体
	void delete(T entity);
	/**
	 * @param hql
	 * @return
	 */
	public List find(String hql);
}
