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
 * 演示HQL的查询（单表查询）
 * 1.全表查询
 * 2.别名查询
 * 3.条件查询
 * 4.具名查询
 * 5.分页查询
 * 6.查询排序
 * 7.聚合查询
 * 8.投影查询
 * @author admin
 *
 */

public class Demo4 {

	/**
	 * 全表查询
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 别名查询
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select o from Order o");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 条件查询
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order where orderno = '201709070001'");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 条件查询2
	 */
	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order where orderno = ?");
		query.setParameter(0, "201709070001");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	/**
	 * 具名查询
	 */
	@Test
	public void test5(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order where orderno = :orderno");
		query.setParameter("orderno", "201709070001");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 分页查询
	 */
	@Test
	public void test6(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order");
		//设置起始行，从0开始
		query.setFirstResult(0);
		//设置查询的条数
		query.setMaxResults(2);
		
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	/**
	 * 查询排序
	 */
	@Test
	public void test7(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order order by id desc");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 聚合查询
	 */
	@Test
	public void test8(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select count(*) from Order");
		/**
		//语法一:
		List<Long> list = query.list();
		Long count = list.get(0);
		System.out.println(count);
		*/
		
		Long count = (Long)query.uniqueResult();
		System.out.println(count);
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 投影查询 查询局部字段
	 */
	@Test
	public void test9(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select orderno,productName from Order");
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
	 * 投影查询2
	 */
	@Test
	public void test10(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select new com.yingxs.domain.Order(orderno,productName) from Order");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order.getOrderno()+"\t"+order.getProductName());
		}
		tx.commit();
		session.close();
		
	}
	
}
