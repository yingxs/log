package com.yingxs.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yingxs.service.UserService;

public class UserAction extends ActionSupport {
	
	private UserService userService;

	@Override
	public String execute() throws Exception {
		
		System.out.println("action.............");
		userService.add();
		
		return NONE;
	}
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
