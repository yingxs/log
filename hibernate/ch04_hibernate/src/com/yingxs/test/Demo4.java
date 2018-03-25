package com.yingxs.test;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示延迟加载
 * @author admin
 *
 */

public class Demo4 {

	/***
	 * 类级别的延迟加载
	 */

	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		/*
		//get():get方法不支持类级别的延迟加载
		Customer cust = session.get(Customer.class, 1);
		System.out.println(cust.getName());
		*/
		
		
		
		//load():load():只有load方法才支持类级别的延迟加载
		Customer cust = session.load(Customer.class, 1);
		System.out.println(cust.getName());
		
		
		tx.commit();
		session.close();
	}
	
	/**
	 * 关联级别的延迟加载( 一对多: <set/> )
	 * 修改一对多的延迟加载配置：
	 * 		<set name="orders"  inverse="true" lazy="false">
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.get(Customer.class, 1);
		//关联订单
		System.out.println(cust.getOrders().size());	//延迟加载的
		
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 
	 * 关联级别的延迟加载( 多对一: <many-to-one/> )
	 * 修改多对一的延迟加载配置：
	 * 		<many-to-one name="customer" class="Customer" column="cust_id" lazy="false" ></many-to-one>
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order order = session.get(Order.class, 1);
		System.out.println(order.getCustomer().getName());		//非延迟加载
		
		tx.commit();
		session.close();
	}
	
}
