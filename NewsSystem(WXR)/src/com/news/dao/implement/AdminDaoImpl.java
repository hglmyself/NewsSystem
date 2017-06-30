/**
* @Title: Admin.java
* @Package com.news.dao.implement
* @Description: TODO
* @author Lover
* @date 2017年6月21日
* @version V1.0
*/
package com.news.dao.implement;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.news.dao.daointerface.AdminDao;
import com.news.pojo.Admin;

/**
 * @author Lover
 * @date:日期：2017年6月21日
 */
@Repository
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{
	@Override
	public Admin login(Admin admin) {
		//验证用户名和密码是否正确
		String hql="from Admin where username=? and password=?";
		@SuppressWarnings("unchecked")
		List<Admin> list=(List<Admin>) getHibernateTemplate()
				.find(hql, admin.getUsername(),admin.getPassword());
		System.out.println(list.size());
		if (list!=null && list.size()>0) {
			System.out.println(list.size());
			return list.get(0);
		}
		return null;
	}

}
