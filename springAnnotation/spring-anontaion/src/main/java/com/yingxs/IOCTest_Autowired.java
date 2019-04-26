package com.yingxs;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yingxs.bean.Boss;
import com.yingxs.config.MainConfigOfAutowired;
import com.yingxs.dao.BookDao;
import com.yingxs.service.BookService;

public class IOCTest_Autowired {
	
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
		BookService bookService = applicationContext.getBean(BookService.class);
//		
//		BookDao bookDao = applicationContext.getBean(BookDao.class);
//		
//		System.out.println(bookService);
//		
//		System.out.println(bookDao);
//		
//		printBeans(applicationContext);
//		applicationContext.close();
		
		
		Boss boss = applicationContext.getBean(Boss.class);
		System.out.println(boss);
		
		
		
		
		
	}
	
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

}
