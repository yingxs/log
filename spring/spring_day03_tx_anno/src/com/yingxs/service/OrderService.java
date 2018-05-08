package com.yingxs.service;

import org.springframework.transaction.annotation.Transactional;

import com.yingxs.dao.OrderDao;

@Transactional
public class OrderService {

	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public void accountMoney(){
		//小王扣除1000
		orderDao.lessMoney();
		int i=1/0;
		//小马增加1000
		orderDao.moreMoney();
	}
}



