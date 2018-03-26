package com.yingxs.Threadlocation;

import org.hibernate.Session;
import com.yingxs.domain.Customer;
import com.yingxs.utils.HibernateUtil;

public class CustomerDao {
	

	
	public void save(Customer cust){
		Session session = HibernateUtil.getSession();
		session.save(cust);
		//²»ÄÜ¹Ø±ÕSession
//		session.close();
	}

}
