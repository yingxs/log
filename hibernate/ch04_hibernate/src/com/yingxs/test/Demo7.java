package com.yingxs.test;


import org.hibernate.Session;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示二级缓存
 * @author admin
 *
 */

public class Demo7 {

	
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		//第1次操作
		Customer cust = session.get(Customer.class, 1);
		System.out.println(cust.getName());
		//关闭session
		session.close();
		
		//第2次操作
		session = HibernateUtil.getSession();
		cust = session.get(Customer.class, 1);
		System.out.println(cust.getName());
		session.close();
	}
	
	
	
}
