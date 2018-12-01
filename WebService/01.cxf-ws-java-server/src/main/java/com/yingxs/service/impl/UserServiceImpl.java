package com.yingxs.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yingxs.domain.User;
import com.yingxs.service.UserService;

public class UserServiceImpl implements UserService {

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("保存用户："+user);
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("更新用户："+user);
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("删除用户："+user);
	}

	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User(1,"张三","男"));
		users.add(new User(2,"李四","男"));
		users.add(new User(3,"陈六","女"));
		return users;
	}

	public User findById() {
		// TODO Auto-generated method stub
		return new User(1,"肉丝","男");
	}

}
