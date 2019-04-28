package com.yingxs;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yingxs.aop.MathCalculator;
import com.yingxs.bean.Boss;
import com.yingxs.config.MainConfigOfAOP;
import com.yingxs.config.MainConfigOfAutowired;
import com.yingxs.dao.BookDao;
import com.yingxs.service.BookService;

public class IOCTest_AOP {
	
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		
		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
		mathCalculator.div(1,0);
		
		
		
		
	}
	
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

}
