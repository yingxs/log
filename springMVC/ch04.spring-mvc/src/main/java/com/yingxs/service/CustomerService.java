package com.yingxs.service;

import java.util.List;

import com.yingxs.domain.Customer;

public interface CustomerService {
	public abstract void save(Customer customer);
	public abstract List<Customer> findAll();
	public abstract Customer findById(Long custId);
	public abstract void update(Customer customer);
}
