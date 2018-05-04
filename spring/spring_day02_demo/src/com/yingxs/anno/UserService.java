package com.yingxs.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {
	
	//得到dao对象
	//1.定义dao类型的属性,不需要set方法
	//2.在dao属性上使用注解，完成对象注入
//	@Autowired
//	private UserDao userDao;
	
	//name属性写创建dao对象的value值
	@Resource(name="userDao123")
	private UserDao userDao;
	
	public void add(){
		System.out.println("service............");
		userDao.add();
	}

}
