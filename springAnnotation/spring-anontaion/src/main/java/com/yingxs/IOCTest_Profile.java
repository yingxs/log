package com.yingxs;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yingxs.bean.Boss;
import com.yingxs.bean.Yellow;
import com.yingxs.config.MainConfigOfAutowired;
import com.yingxs.config.MainConfigOfPropertyValue;
import com.yingxs.config.MainConfigProfile;
import com.yingxs.dao.BookDao;
import com.yingxs.service.BookService;

public class IOCTest_Profile {
	
	@Test
	public void test01() {
	
		// 1.创建一个applicationContext
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 2.设置需要激活
		applicationContext.getEnvironment().setActiveProfiles("test");
		// 3.注册配置类
		applicationContext.register(MainConfigProfile.class);
		// 4.启动刷新容器
		applicationContext.refresh();
		
		
		
		
		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : namesForType) {
			System.out.println(string);
		}
		
		Yellow yellow = applicationContext.getBean(Yellow.class);
		System.out.println(yellow);
		applicationContext.close();
	}
	
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

}
