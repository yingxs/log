package com.yingxs.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.yingxs.dao.CustomerDao;
import com.yingxs.domain.Customer;

@Repository
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

}
