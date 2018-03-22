package com.yingxs.test;
/**
 * 演示一对一关系(唯一外键关联)
 */
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.one2one_fk.Card;
import com.yingxs.one2one_fk.Person;
import com.yingxs.utils.HibernateUtil;

public class Demo4 {

	/**
	 * 添加操作
	 */
	@Test
	public void test1(){
		Person p = new Person();
		p.setName("小苍");
		
		Card c = new Card();
		c.setName("1001");
		
		c.setPerson(p);
		p.setCard(c);
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(c);
		session.save(p);
		
		
		tx.commit();
		session.close();
		
	}

}
