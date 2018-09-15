package com.yingxs.crm.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.yingxs.crm.dao.ICustomerDao;
import com.yingxs.crm.domain.Customer;


@Repository
public class CustomerDaoImpl extends HibernateDaoSupport implements ICustomerDao {

	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void save(Customer cust) {
		this.getHibernateTemplate().save(cust);
	}

}
