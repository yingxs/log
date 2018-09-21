package com.yingxs.dao.impl;

import java.util.List;

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

	@Override
	public List<Customer> findAll() {
		return  this.getHibernateTemplate().loadAll(Customer.class);
	}

	@Override
	public Customer findById(Long custId) {
		return this.getHibernateTemplate().get(Customer.class, custId);
	}

	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

}
