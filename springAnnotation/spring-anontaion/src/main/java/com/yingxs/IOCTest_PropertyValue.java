package com.yingxs;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.yingxs.bean.Person;
import com.yingxs.config.MainConfigOfPropertyValue;

public class IOCTest_PropertyValue {

	// 创建IOC容器
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			MainConfigOfPropertyValue.class);

	@Test
	public void test01() {
		printBeans(applicationContext);
		System.out.println("=====================================");
		
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
		// 除了${...}获取之外，也可以用这种方式获取配置文件中的值
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("person.nickName");
		System.out.println(property);
		
		
		// 关闭容器
		applicationContext.close();
	}

	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}
	
	
	
}
