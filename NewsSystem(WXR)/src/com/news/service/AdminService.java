package com.news.service;

import com.news.pojo.Admin;

public interface AdminService {
	//业务层检查用户名和密码是否正确
	public Admin login(Admin admin);
}
