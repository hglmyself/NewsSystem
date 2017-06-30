package com.news.dao.daointerface;

import com.news.pojo.Admin;
public interface AdminDao extends BaseDao<Admin>{
	//ÑéÖ¤µÇÂ¼
	public Admin login(Admin adminUser);
}
