package com.yingxs.test;

import org.junit.Test;

import com.yingxs.Threadlocation.CustomerService;
import com.yingxs.domain.Customer;


/**
 * 演示Threadlocation
 * @author admin
 *
 */

public class Demo2 {

	

	/**
	 * 没有Threadlocat
	 */
	@Test
	public void test1(){
		
		Customer c1 = new Customer();
		c1.setName("张三");
		
		Customer c2 = new Customer();
		c2.setName("李四");
		
		CustomerService service = new CustomerService();
		service.save(c1, c2);
	}
	
	
	
}
