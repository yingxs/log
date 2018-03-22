package com.yingxs.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.one2many.Customer;
import com.yingxs.one2many.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示一对多的操作
 */
public class Demo2 {

	/**
	 * 保存操作
	 */
	@Test
	public void test1(){
		
		//准备数据
		//需求：一个客户两张订单
		Customer cust = new Customer();
		cust.setName("小苍");
		cust.setGender("女");
		
		
		Order o1 = new Order();
		o1.setOrderno("201709070001");
		o1.setProductName("JavaWeb开发详解");
		
		Order o2 = new Order();
		o2.setOrderno("201709070002");
		o2.setProductName("Spring开发详解");
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//建立一对多双向关联关系
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		o1.setCustomer(cust);
		o2.setCustomer(cust);
		
		
		session.save(cust);
		session.save(o1);
		session.save(o2);
		
		tx.commit();
		session.close();
		
	}
	
	
	/**
	 * 查询操作
	 */
	@Test
	public void test2(){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//查询一个客户，关联查询订单
		Customer cust = session.get(Customer.class, 1);
		System.out.println(cust.getName()+"的订单：");
		Set<Order> orders = cust.getOrders();
		for (Order order : orders) {
			System.out.println(order.getOrderno()+" , "+order.getProductName());
		}
		tx.commit();
		session.close();
		
	}

	
	
	
	
	/**
	 * 尝试修改操作
	 * 只给客户对象添加ID，hiber会忽略此ID的添加  将此客户作为一条新的记录插入，订单记录也是如此
	 */
	@Test
	public void test3(){
		
		//准备数据
		//需求：一个客户两张订单
		Customer cust = new Customer();
		cust.setId(1);						//只给客户对象添加ID
		cust.setName("小泽");
		cust.setGender("女");
		
		
		Order o1 = new Order();
		o1.setOrderno("201709070003");
		o1.setProductName("金瓶梅");
		
		Order o2 = new Order();
		o2.setOrderno("201709070004");
		o2.setProductName("三体");
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//建立一对多双向关联关系
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		o1.setCustomer(cust);
		o2.setCustomer(cust);
		
		
		session.save(cust);
		session.save(o1);
		session.save(o2);
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 尝试修改操作   失败，作为新纪录添加
	 * 只给订单对象添加ID，hiber会忽略此ID的添加  将此客户作为一条新的记录插入，对应的客户记录也是如此
	 */
	@Test
	public void test4(){
		
		//准备数据
		//需求：一个客户两张订单
		Customer cust = new Customer();

		cust.setName("小黑");
		cust.setGender("男");
		
		
		Order o1 = new Order();
		o1.setId(1);
		o1.setOrderno("201709070005");
		o1.setProductName("信息简史");
		
		Order o2 = new Order();
		o2.setId(2);
		o2.setOrderno("201709070006");
		o2.setProductName("奇点");
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//建立一对多双向关联关系
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		o1.setCustomer(cust);
		o2.setCustomer(cust);
		
		
		session.save(cust);
		session.save(o1);
		session.save(o2);
		
		tx.commit();
		session.close();
		
	}
	
	
	
	
	/**
	 * 尝试修改操作   失败
	 * 给订单对象和客户对象同时添加ID，失败，客户和订单信息作为新纪录被添加
	 */
	@Test
	public void test5(){
		
		//准备数据
		//需求：一个客户两张订单
		Customer cust = new Customer();
		cust.setId(1);
		cust.setName("小白");
		cust.setGender("男");
		
		
		Order o1 = new Order();
		o1.setId(1);
		o1.setOrderno("201709070007");
		o1.setProductName("平凡的世界");
		
		Order o2 = new Order();
		o2.setId(2);
		o2.setOrderno("201709070008");
		o2.setProductName("摆渡人");
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//建立一对多双向关联关系
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		o1.setCustomer(cust);
		o2.setCustomer(cust);
		
		
		session.save(cust);
		session.save(o1);
		session.save(o2);
		
		tx.commit();
		session.close();
		
	}
	
	
	
	
	/**
	 * 保存操作 - 级联保存
	 */
	@Test
	public void test6(){
		
		//准备数据
		//需求：一个客户两张订单
		Customer cust = new Customer();
		cust.setName("小苍");
		cust.setGender("女");
		
		
		Order o1 = new Order();
		o1.setOrderno("201709070001");
		o1.setProductName("JavaWeb开发详解");
		
		Order o2 = new Order();
		o2.setOrderno("201709070002");
		o2.setProductName("Spring开发详解");
		
		Order o3 = new Order();
		o3.setOrderno("201709070003");
		o3.setProductName("servlet的实战");
		
		Order o4 = new Order();
		o4.setOrderno("201709070004");
		o4.setProductName("hibernate的原理分析");
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		
		/*
		//建立一对多单向关联关系，客户只关联订单
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		
		session.save(cust);//使用级联保存（想保存客户的时候，同时保存订单）
		此单向关联关系是靠客户去维护订单，但是现在又放弃了客户的维护权
		因此：
		*/
		
		o1.setCustomer(cust);
		o2.setCustomer(cust);
		o3.setCustomer(cust);
		o4.setCustomer(cust);
		
		session.save(o1);
		session.save(o2);
		session.save(o3);
		session.save(o4);

		tx.commit();
		session.close();
		
	}
	
	
	/**
	 * 级联删除
	 * PS：如果没有级联删除，那么在删除客户的时候，会把订单表的cust_id外键值设置为NULL
	 * PS：如果有级联删除，那么在删除客户的时候，会把该客户的所有订单删除
	 */
	@Test
	public void test7(){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.get(Customer.class, 2);
		session.delete(cust);
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 尝试级级联更新 失败  暂时未知
	 *	只给客户对象加iD，无效
	 */
	@Test
	public void test8(){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Customer cust = new Customer();
		cust.setId(1);
		cust.setName("小白");
		cust.setGender("女");
		
		
		
		Order o1 = new Order();
		o1.setOrderno("201709070003");
		o1.setProductName("JavaWeb开发详解1");
		
		Order o2 = new Order();
		o2.setOrderno("201709070004");
		o2.setProductName("Spring开发详解2");
		
		
		tx.commit();
		session.close();
		
	}

}
