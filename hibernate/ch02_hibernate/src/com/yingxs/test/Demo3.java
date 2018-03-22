package com.yingxs.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.many2many.Role;
import com.yingxs.many2many.User;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示多对多的操作
 * @author admin
 *
 */
public class Demo3 {
	
	
	/**
	 * 添加操作
	 */
	@Test
	public void tes1(){
		/**
		 * 需求：建立两个用户，两个角色
		 */
		
		User u1 = new User();
		u1.setName("小苍");
		
		User u2 = new User();
		u2.setName("小泽");
		
		Role r1 = new Role();
		r1.setName("超级管理员");
		
		Role r2 = new Role();
		r2.setName("普通管理员");
		
		//建立双向关系
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		r1.getUsers().add(u1);
		r2.getUsers().add(u1);
		
		u2.getRoles().add(r2);
		r2.getUsers().add(u2);
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 查询操作
	 */
	@Test
	public void tes2(){
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//查询一个用户，该用户所有的角色
		User user = session.get(User.class, 1);
		Set<Role> roles = user.getRoles();
		System.out.println("当前用户为："+user.getName()+"，角色有：");
		for (Role role : roles) {
			System.out.println(role.getName());
		}
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 级联添加操作
	 */
	@Test
	public void tes3(){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setName("老王");
		
		Role r = new Role();
		r.setName("基础u管理员");
		
		
		//级联添加操作
		u.getRoles().add(r);
		
		session.save(u);
		
		
		tx.commit();
		session.close();
	}
	
	
	
	/**
	 * 级联删除操作
	 */
	@Test
	public void tes4(){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		/**
		 * 删除用户，会同时删除中间表中和用户相关的数据，还删除了对应的角色数据
		 * 在实际开发中，在多对多的关系中不使用级联删除 
		 */
		User u = session.get(User.class, 3);
		session.delete(u);
		
		
		tx.commit();
		session.close();
	}
	
	
	

}
