package com.yingxs.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibrtnate开发的工具类
 * @author admin
 *
 */
public class HibernateUtil {
	private static Configuration cfg = null;
	private static SessionFactory sessionFactory = null;
	
	static{
		cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}
	
	
	public static Session getSessionobject(){
		return sessionFactory.getCurrentSession();
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static void main(String[] args) {
		
	}

}
