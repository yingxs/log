package com.yingxs.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.yingxs.entity.User;

public class UserDaoImpl implements UserDao {
	
	//注入hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public void add() {
		//HibernateTemplate对hibernate进行封装
//		User user = new User();
//		user.setUsername("rose");
//		user.setAddress("japan");
//		
//		//调用save实现添加
//		hibernateTemplate.save(user);
		
		//1.get方法：根据id查询
//		User user = hibernateTemplate.get(User.class, 2);
//		System.out.println(user.getUsername()+"::"+user.getAddress());
		
		
		//2. find方法查询所有记录
//		List<User> list =  (List<User>) hibernateTemplate.find("from User");
//		for (User user : list) {
//			System.out.println(user.getUsername()+"::"+user.getAddress());
//		}
		
		//3. find方法条件查询
		List<User> list =  (List<User>) hibernateTemplate.find("from User where username=?","lucy");
		for (User user : list) {
			System.out.println(user.getUsername()+"::"+user.getAddress());
		}
		
	}
}
