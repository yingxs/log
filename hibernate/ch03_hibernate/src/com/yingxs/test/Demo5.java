package com.yingxs.test;


import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示本地SQl的查询
 */

public class Demo5 {

	//以对象数组的形式封装
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		
		SQLQuery sqlQuery = session.createSQLQuery("select * from t_order");
		List<Object[]> list = sqlQuery.list();
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		tx.commit();
		session.close();
		
	}
	
	
	//以JavaBean对象的形式封装
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		
		SQLQuery sqlQuery = session.createSQLQuery("select * from t_order");
		sqlQuery.addEntity(Order.class);
		List<Order> list = sqlQuery.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
		
	}
	
}
