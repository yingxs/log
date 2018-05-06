package com.yingxs.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yingxs.c3p0.UserService;

public class TestC3p0 {
	
	@Test
	public void testDemo(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		UserService service = (UserService) context.getBean("userService");
		service.add();
		
	}

}
