package com.yingxs.test;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yingxs.domain.Customer;

/**
 * hibernate的helloworld
 * @author admin
 *
 */
public class Demo1 {

	
	@Test
	public void test1(){
		Customer customer = new Customer();
		customer.setName("老王22");
		customer.setAge(42);
		customer.setGender("男");
		customer.setLevel("VIP客户");
		
		
		
		//1.读取hibernate.cfg.xml文件
		Configuration cfg = new Configuration();
		cfg.configure();
//		cfg.configure(new File("./src/hbm.cfg.xml"));
		
		
		//2.创建SessionFactory工厂
		SessionFactory factory = cfg.buildSessionFactory();
		//3.创建Session事务
		Session session = factory.openSession();
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
