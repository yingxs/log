package com.yingxs.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yingxs.entity.User;

public class UserAction extends ActionSupport {
	
	private User user;
	

	public String register()  {
		System.out.println("调用了UserAction的register方法");
		return SUCCESS;
	}
	
	
	
	public String login()  {
		if("yinxs".equals(user.getName()) && "123456".equals(user.getPassword())){
			
			
			//登录成功
			//保存数据到session域
			ActionContext ac = ActionContext.getContext();
			Map<String, Object> sessionMap = ac.getSession();
			sessionMap.put("user", user);
			//跳转到用户主页
			return SUCCESS;
			
		}else{
			//登陆失败
			return ERROR;
		}
			
	}


	
	
	
	
	
	
	
	
	
	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
	
	
	
	
}
