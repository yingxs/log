package com.yingxs.service;

import org.springframework.transaction.annotation.Transactional;

import com.yingxs.dao.UserDao;

@Transactional
public class UserService {
	//×¢Èëdao¶ÔÏó
		private UserDao userDao;
		
		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}
		
		public void add(){
			System.out.println("service..........");
			userDao.add();
		}
}
