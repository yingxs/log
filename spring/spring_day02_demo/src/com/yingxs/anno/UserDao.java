package com.yingxs.anno;

import org.springframework.stereotype.Component;

@Component(value="userDao123")
public class UserDao {
	public void add(){
		System.out.println("dao.........");
	}

}
