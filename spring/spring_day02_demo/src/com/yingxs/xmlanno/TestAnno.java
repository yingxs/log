package com.yingxs.xmlanno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {

	@Test
	public void testUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		BookService bookService = (BookService) context.getBean("bookService");
		System.out.println(bookService);
		bookService.add();
	}

}
