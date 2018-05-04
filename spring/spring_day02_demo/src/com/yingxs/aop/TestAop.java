package com.yingxs.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
		Book book = (Book) context.getBean("book");
		book.add();
	}

}
