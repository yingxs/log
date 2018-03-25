package com.yingxs.test;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示Hibernate对象的三种状态
 * @author admin
 *
 */

public class Demo1 {


	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();	//这时的c对象没有OID值，没有被session管理，这时c对象就是临时状态的对象
		c.setName("老王");
		
		session.save(c);			//这时的c对象有OID的值，被session管理 ，属于持久态对象
		System.out.println(c.getId());
		
		tx.commit();
		session.close();
		
		System.out.println(c);			//这时的c对象有OID的值，没有被session管理 ，属于游离态对象
		
	}
	
	
	
}
