package com.yingxs.crm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yingxs.crm.dao.ICustomerDao;
import com.yingxs.crm.domain.Customer;
import com.yingxs.crm.service.ICustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	@Resource
	private ICustomerDao customerDao;
	
	@Override
	public void save(Customer cust) {
		customerDao.save(cust);
	}
	
}
