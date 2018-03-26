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
	private static SessionFactory factoy = null;
	
	static{
		cfg = new Configuration();
		cfg.configure();
		factoy = cfg.buildSessionFactory();
	}
	
	public static Session getSession(){
//		return factoy.openSession();
		return factoy.getCurrentSession();
		
	}

}
