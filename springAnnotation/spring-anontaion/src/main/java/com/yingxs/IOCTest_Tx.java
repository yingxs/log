package com.yingxs;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yingxs.tx.TxConfig;
import com.yingxs.tx.UserService;

public class IOCTest_Tx {
	
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(TxConfig.class);
		
		UserService userService = applicationContext.getBean(UserService.class);
		userService.insertUser();
		applicationContext.close();
		
	}
	

}
