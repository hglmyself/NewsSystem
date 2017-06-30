package com.news.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = invocation.getInvocationContext();
		@SuppressWarnings("rawtypes")
		Map session = actionContext.getSession();
		
		if (session.get("username")!=null) {
			//System.out.println("用户已登录"+session.get("username"));
			return invocation.invoke();
		}
		else {
			actionContext.put("tip", "您还没登录。请先登录！");
			return Action.LOGIN;
		}
		
	}

}
