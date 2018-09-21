package com.yingxs.dao;

import java.util.List;

import com.yingxs.domain.Customer;

public interface CustomerDao {
	public abstract void save(Customer customer);
	public abstract List<Customer> findAll();
	public abstract Customer findById(Long custId);
	public abstract void update(Customer customer);
	public abstract void delete(Long custId);
}
