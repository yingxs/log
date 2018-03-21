package com.yingxs.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.utils.HibernateUtil;
/**
 * 演示Session接口进行增删改查
 * @author admin
 *
 */
public class Demo3 {
	/**
	 * save();
	 */
	@Test
	public void test1(){
		Customer customer = new Customer();
		customer.setName("老王333");
		customer.setAge(42);
		customer.setGender("男");
		customer.setLevel("VIP客户");
		
		
		Session session = HibernateUtil.getSession();

		//4.开启事务,打开事务并返回事务对象
		Transaction tx = session.beginTransaction();
		//5.执行添加操作
		session.save(customer);
		//6.提交事务
		tx.commit();
		//7.关闭资源
		session.close();
		
	}
	
	/**
	 * update();
	 */
	@Test
	public void test2(){
		Customer customer = new Customer();
		//给Customer的id赋值，才可以更新
		customer.setId(1);
		customer.setName("老王333");
		customer.setAge(45);
		customer.setGender("男");
		customer.setLevel("VIP客户");
		
		
		Session session = HibernateUtil.getSession();

		//4.开启事务,打开事务并返回事务对象
		Transaction tx = session.beginTransaction();
		//5.执行添加操作
		session.update(customer);
		//6.提交事务
		tx.commit();
		//7.关闭资源
		session.close();
		
	}
	
	
	
	/**
	 * saveOrUpdate(Object obj);添加或修改对象
	 * 有id为update，无id为save
	 */
	@Test
	public void test3(){
		Customer customer = new Customer();
		//给Customer的id赋值，才可以更新
		customer.setId(6);
		customer.setName("老王666");
		customer.setAge(50);
		customer.setGender("男");
		customer.setLevel("VIP客户");
		
		
		Session session = HibernateUtil.getSession();

		//4.开启事务,打开事务并返回事务对象
		Transaction tx = session.beginTransaction();
		//5.执行添加操作
		session.saveOrUpdate(customer);
		//6.提交事务
		tx.commit();
		//7.关闭资源
		session.close();
		
	}
	

	/**
	 * delete(Object obj);删除对象
	 * 有id为update，无id为save
	 */
	@Test
	public void test4(){
		Customer customer = new Customer();
		//给Customer的id赋值，才可以更新
		customer.setId(2);
		Session session = HibernateUtil.getSession();
		//4.开启事务,打开事务并返回事务对象
		Transaction tx = session.beginTransaction();
		//5.执行添加操作
		session.delete(customer);
		//6.提交事务
		tx.commit();
		//7.关闭资源
		session.close();
		
	}
	

	/**
	 * get(Class clz,Serialize id): 获取对象
	 * load(Class clz,Serialize id): 获取对象
	 */
	@Test
	public void test5(){
		Session session = HibernateUtil.getSession();
		//4.开启事务,打开事务并返回事务对象
		Transaction tx = session.beginTransaction();
		//5.执行添加操作
//		Customer cust = session.get(Customer.class,6);
		Customer cust = session.load(Customer.class,6);
		System.out.println(cust);
		//6.提交事务
		tx.commit();
		//7.关闭资源
		session.close();
		
	}
}
