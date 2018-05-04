package com.yingxs.service;

import com.yingxs.dao.UserDao;

public class UserService {
	
	private UserDao userDao;
	


	public void add(){
		System.out.println("service.......");
		userDao.add();
	}
	
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		
	}
	
}
