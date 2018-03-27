package com.ht.interceptor;

import org.apache.struts2.ServletActionContext;

import com.ht.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义一个struts2拦截器，实现用户未登录，自动跳转到登录页面
 */
public class LoginInterceptor extends MethodFilterInterceptor {
	// 拦截方法
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		System.out.println("进了默认拦截器");
		if(user == null){
			//未登录，跳转到登录页面
			return "login";
		}
		return invocation.invoke();// 放行
	}
}
