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
 * 演示抓取策略的管理
 * @author admin
 *
 */

public class Demo5 {

	/***
	 * 一方：<set/>
	 * fetch="select" ：默认情况下，执行两条SQL语句
	 * fetch="join"	: 把两条SQL语句合并成左外连接查询(效率高一点，但是如果配置了join延迟加载失效)
	 */

	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.get(Customer.class, 1);
		System.out.println(cust.getOrders());
		
		tx.commit();
		session.close();
	}
	
	
	/***
	 * 一方：<set/>
	 * 需求：在查询多个一方(客户)的数据，关联查询多方(订单)的数据，如果fetch的配置是select的时候，一共发出n+1条sql语句
	 * fetch="subselect"	: 使用子查询进行关联查询
	 */
	
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer.getOrders().size());
		}
		
		tx.commit();
		session.close();
	}
	
	
	/***
	 * 多方：<many-to-one/>
	 * fetch="select" ：默认情况下，执行两条SQL语句（支持延时加载）
	 * fetch="join"	: 把两条SQL语句合并成左外连接查询(效率高一点，但是如果配置了join延迟加载失效)
	 * 
	 */

	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order order = session.get(Order.class, 1);
		System.out.println(order.getCustomer());
		
		tx.commit();
		session.close();
	}
	
}
