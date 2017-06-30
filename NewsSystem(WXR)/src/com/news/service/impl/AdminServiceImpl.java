/**
* @Title: AdminServiceImpl.java
* @Package com.news.service.impl
* @Description: TODO
* @author Lover
* @date 2017Äê6ÔÂ21ÈÕ
* @version V1.0
*/
package com.news.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.news.dao.daointerface.AdminDao;
import com.news.pojo.Admin;
import com.news.service.AdminService;
@Transactional(readOnly=false)
@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Resource private AdminDao adminDao;
	
	/**
	 * @return the adminDao
	 */
	public AdminDao getAdminDao() {
		return adminDao;
	}

	/**
	 * @param adminDao the adminDao to set
	 */
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Admin login(Admin admin) {
		return adminDao.login(admin);
	}

}
