package com.yingxs.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.utils.HibernateUtil;
/**
 * 使用hibernateUtil工具类
 * @author admin
 *
 */
public class Demo2 {
	
	@Test
	public void test1(){
		Customer customer = new Customer();
		customer.setName("老王22");
		customer.setAge(42);
		customer.setGender("男");
		customer.setLevel("VIP客户");
		
		
		Session session = HibernateUtil.getSession();

		//4.开启事务,打开事务并返回事务对象
		Transaction tx = session.beginTransaction();
		//5.执行添加操作
		session.save(customer);
		//6.提交事务
		tx.commit();
		//7.关闭资源
		session.close();
		
	}
}
