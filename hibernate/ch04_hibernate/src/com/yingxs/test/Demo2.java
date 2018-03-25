package com.yingxs.test;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示一级缓存和快照机制
 * @author admin
 *
 */

public class Demo2 {


	/**
	 * 说明持久态对象确实可以更新数据库的数据
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//获取到一个持久态对象
		Customer cust = session.get(Customer.class, 1);
		cust.setName("老王");
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 使用代码来证明hibernate一级缓存的存在
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//第一次查询
		Customer c1 = session.get(Customer.class, 1);
		System.out.println(c1);
		//第二次查询
		Customer c2 = session.get(Customer.class, 1);
		System.out.println(c2);
		
		
		tx.commit();
		session.close();
	}
	
	
	
}
