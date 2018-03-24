package com.yingxs.test;


import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示HQL的查询（多表查询）
 * 1.内连接查询(inner join)
 * 2.左链接查询(left join)
 * 3.右连接查询(right join)
 *
 */

public class Demo3 {

	/**
	 * 内连接查询
	 * 只会显示满足条件的记录
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//需求：显示客户名称和订单产品名称
		Query query = session.createQuery("select c.name,o.productName from Customer c inner join c.orders o");
		List<Object[]> list = query.list();
	
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		tx.commit();
		session.close();
		
	}
	
	
	
	/**
	 * 左连接查询
	 * 左边的表会全部显示
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//需求：显示客户名称和订单产品名称
		Query query = session.createQuery("select c.name,o.productName from Customer c left join c.orders o");
		List<Object[]> list = query.list();
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		tx.commit();
		session.close();
		
	}
	
	
	
	/**
	 * 右连接查询
	 * 右边的表会全部显示
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//需求：显示客户名称和订单产品名称
		Query query = session.createQuery("select c.name,o.productName from Order o right join o.customer c");
		List<Object[]> list = query.list();
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		tx.commit();
		session.close();
		
	}
	
	
	
}
