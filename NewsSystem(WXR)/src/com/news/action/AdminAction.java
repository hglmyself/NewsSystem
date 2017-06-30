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
	//��ȡ�����ļ�
	private ApplicationContext ac  
		= new ClassPathXmlApplicationContext("applicationContext.xml");
	//��ȡService����
	private AdminService adminService 
		= (AdminService) ac.getBean("adminService");
	
	//ģ������ʹ�õĶ���
	private Admin admin=new Admin();
	//��ȡģ������
	public Admin getModel() {
		return admin;
	}
	
	//��̨��¼ִ�еķ���
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//����service������ɵ�¼
		Admin existAdmin=adminService.login(admin);
		//��������session���ö���
		ActionContext actionContext = ActionContext.getContext();
		@SuppressWarnings("rawtypes")
		//����session�����û�������Ĺ�ϣ��
		Map session = actionContext.getSession();
		//�жϹ���Ա�Ƿ����
		if (existAdmin!=null){
			//���û��������ϣ���ڣ��Թ�Ȩ����������
			session.put("username", admin.getUsername());
			return SUCCESS;
		}
		else {
			//�û������������s
			this.addActionError("�û������������");
			return LOGIN;
		}
	}
	//ע����¼
	public String logout(){
		ActionContext actionContext = ActionContext.getContext();
		@SuppressWarnings("rawtypes")
		Map session = actionContext.getSession();
		//ɾ��session�����ڴ�ŵ�username
		session.remove("username");
		//�ж��Ƿ�remove�ɹ�
		if (session.isEmpty()) {
			System.out.println("ע���ɹ�");
			return LOGIN;
		}
		else {
			session.remove("username");
			System.out.println("����ע��");
			return LOGIN;
		}
	}
	public String adminLogin() throws Exception{
		System.out.println("adminlogin");
		return "adminlogin";
	}

}
