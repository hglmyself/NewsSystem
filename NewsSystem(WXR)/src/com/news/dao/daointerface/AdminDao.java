package com.news.dao.daointerface;

import com.news.pojo.Admin;
public interface AdminDao extends BaseDao<Admin>{
	//��֤��¼
	public Admin login(Admin adminUser);
}
