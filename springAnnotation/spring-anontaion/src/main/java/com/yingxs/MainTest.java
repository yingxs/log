package com.yingxs;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yingxs.bean.Person;
import com.yingxs.config.MainConfig;
import com.yingxs.config.MainConfig2;

public class MainTest {

	/**
	 * xml 方式获取bean
	 */
	@Test
	public void test1() {
		// 根据配置文件创建容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Person bean = (Person)applicationContext.getBean("person");
		System.out.println(bean);
	}
	
	
	
	/**
	 * 注解驱动获取bean
	 */
	@Test
	public void test2() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);
		
		// 容器中该类型的所有组件id 也就是配置类中 返回该bean的方法名
		//但如果@bean中定义了该bean的name那就后者优先
		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String string : namesForType) {
			System.out.println(string);
		}
	}
	
	@Test
	public void test3() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		// 获取容器中所有bena的name
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : definitionNames) {
			System.out.println(string);
		}
	}
	
	@Test
	public void test4() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//		// 获取容器中所有bena的name
		System.out.println("容器创建完成");
//		String[] definitionNames = applicationContext.getBeanDefinitionNames();
//		for (String string : definitionNames) {
//			System.out.println(string);
//		}
//		
		Object bean = applicationContext.getBean("person");
//		Object bean2 = applicationContext.getBean("person");
//		System.out.println(bean == bean2);
		
	}
	
	
	
	
	
	
}
