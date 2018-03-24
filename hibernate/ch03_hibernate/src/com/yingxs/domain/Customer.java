package com.yingxs.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 客户 一方
 * @author admin
 *
 */
public class Customer implements Serializable {
	private Integer id;
	private String name;
	private String gender;
	
	//关联订单
	private Set<Order> orders = new HashSet<Order>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	

	
}
