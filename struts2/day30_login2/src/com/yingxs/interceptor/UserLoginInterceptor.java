package com.yingxs.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.yingxs.entity.User;

public class UserLoginInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		/*
		 * 问题：该拦截器不需要拦截登录(login)和注册(register)请求
		 */
		//得到当前拦截的目标Action的代理对象
		ActionProxy actionProxy = arg0.getProxy();
		//得到当前执行的Action方法名
		String method = actionProxy.getMethod();
		
		if("login".equals(method) || "register".equals(method)){
			//放行
			return arg0.invoke();
		}
		
		//1.获取session中的数据
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> sessionMap = ac.getSession();
		User user = (User)sessionMap.get("user");
		//2.判断session中的数据是否存在
		if(user==null){
			//不存在就跳转到登录页面
			return "login";
		}else{
			//存在就放行
			return arg0.invoke();
		}
	}

}
