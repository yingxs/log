package com.yingxs.test;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示一级缓存的管理
 * @author admin
 *
 */

public class Demo3 {


	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.get(Customer.class, 1);		//cust是持久态对象，在一级缓存中
		cust.setName("老王");
		
		//把cust对象移出一级缓存
//		session.evict(cust);
		
		
		//清空 一级缓存
		session.clear();
		
		tx.commit();
		session.close();
	}
	
}
