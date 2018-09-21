package com.yingxs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yingxs.dao.CustomerDao;
import com.yingxs.domain.Customer;
import com.yingxs.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Resource
	private CustomerDao customerDao;

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public Customer findById(Long custId) {
		return customerDao.findById(custId);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

}
