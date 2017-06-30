package com.news.action;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.news.pojo.Admin;
import com.news.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//读取配置文件
	private ApplicationContext ac  
		= new ClassPathXmlApplicationContext("applicationContext.xml");
	//获取Service配置
	private AdminService adminService 
		= (AdminService) ac.getBean("adminService");
	
	//模型驱动使用的对象
	private Admin admin=new Admin();
	//获取模型驱动
	public Admin getModel() {
		return admin;
	}
	
	//后台登录执行的方法
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//调用service方法完成登录
		Admin existAdmin=adminService.login(admin);
		//创建缓存session引用对象
		ActionContext actionContext = ActionContext.getContext();
		@SuppressWarnings("rawtypes")
		//创建session缓存用户名密码的哈希表
		Map session = actionContext.getSession();
		//判断管理员是否存在
		if (existAdmin!=null){
			//把用户名放入哈希表内，以供权限拦截器用
			session.put("username", admin.getUsername());
			return SUCCESS;
		}
		else {
			//用户名或密码错误s
			this.addActionError("用户名或密码错误！");
			return LOGIN;
		}
	}
	//注销登录
	public String logout(){
		ActionContext actionContext = ActionContext.getContext();
		@SuppressWarnings("rawtypes")
		Map session = actionContext.getSession();
		//删除session容器内存放的username
		session.remove("username");
		//判断是否remove成功
		if (session.isEmpty()) {
			System.out.println("注销成功");
			return LOGIN;
		}
		else {
			session.remove("username");
			System.out.println("继续注销");
			return LOGIN;
		}
	}
	public String adminLogin() throws Exception{
		System.out.println("adminlogin");
		return "adminlogin";
	}

}
