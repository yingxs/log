package com.yingxs.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		
		System.out.println("action.............");
		return NONE;
	}
}
