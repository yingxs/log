package com.yingxs.test;


import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示Criteria的查询（单表查询）
 * 1.全表查询
 * 2.条件查询
 * 3.分页查询
 * 4.查询排序
 * 5.聚合查询
 * 6.投影查询
 * @author admin
 *
 */

public class Demo2 {

	/**
	 * 全表查询
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Customer.class);
		List<Customer> list = ce.list();
		for (Customer customer : list) {
			System.out.println(customer.getName());
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 条件查询
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		//添加查询条件 orderno = '20170907003'
		ce.add( Restrictions.eq("orderno", "201709070003") );
		List<Order> list = ce.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 条件查询2(多条件)
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//添加查询条件 orderno like '%2017%' and productName like '%JavaWeb%'
		ce.add( Restrictions.and(Restrictions.like("orderno", "%2017%"), Restrictions.like("productName", "%JavaWeb%")));
		List<Order> list = ce.list();
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
	public void test4(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		//分页查询
		ce.setFirstResult(0);	//起始行
		ce.setMaxResults(2);	//查询行数
		
		
		List<Order> list = ce.list();
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
	public void test5(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//排序 order by id desc
		ce.addOrder( org.hibernate.criterion.Order.desc("id"));
		
		List<Order> list = ce.list();
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
	public void test6(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//查询总记录数 select count (id)
		//ce.setProjection(Projections.count("id"));
		
		//查询id中的最大值
		ce.setProjection(Projections.max("id"));
		
		Integer count = (Integer)ce.uniqueResult();
		System.out.println(count);
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 投影查询
	 */
	@Test
	public void test7(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//投影操作
		ProjectionList pList = Projections.projectionList();
		pList.add(Property.forName("orderno"));
		pList.add(Property.forName("productName"));
		
		ce.setProjection(pList);
		
		List<Object[]> list = ce.list();
		System.out.println(list);
		
		/*for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}*/
		
		tx.commit();
		session.close();
		
	}
	
}
