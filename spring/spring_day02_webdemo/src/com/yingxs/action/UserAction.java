package com.yingxs.action;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yingxs.service.UserService;

public class UserAction extends ActionSupport{
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("action.......");

		return NONE;
	}
	
}
