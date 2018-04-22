# Spring

## Spring概念
### 1.spring是开源的的轻量级框架
### 2.spring核心部分
* aop:面向切面编程，扩展功能不是修改源码实现
* ioc：控制反转
	* 有一个类，在类中有方法（不是静态方法），调用类里面的方法，需要使用对象调用方法，创建类对象的过程，需要new出来对象
	* 把对象的创建不是通过new的凡是实现的，而是交给spring配置创建类对象 
### 3.spring是一站式框架
> spring在javaee三层结构中，每一层都提供了不同的解决技术

* web层：springMVC
* service层：spring的ioc
* dao层，spring的jdbcTemplate



### Spring的ioc操作
* 把对象的创建交给spring进行管理
* ioc操作的两部分
	* ioc的配置文件方式
	* ico的注解方式 
### IOC的底层原理
* IOC底层原理使用的技术
	* XML配置文件
	* dom4j
	* 工厂设计模式 
	* 反射

## IOC入门案例
* 1.导入jar包
	*  http://repo.spring.io/release/org/springframework/spring/
	*  做spring最基本功能的时候，导入四个核心jar就可以了
	*  导入支持日志输出的jar包
* 2.创建类，在类中创建方法
```
	package com.yingxs.ioc;

	public class User {
	public void add(){
		System.out.println("add.....");
	}
	public static void main(String[] args) {
		//原始做法
		User user = new User();
		user.add();
	}
	}
```
* 3.创建spring配置文件，配置创建类
	* spring核心配置文件名称和位置不是固定的，建议放到src下，官方建议applicationContext.xml;
	* 引入schema约束
	```
		<beans xmlns="http://www.springframework.org/schema/beans"
		    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		    xsi:schemaLocation="
		        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	```
	* 配置对象创建
	```
		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
		    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		    xsi:schemaLocation="
		        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
			
			<!-- ioc入门 -->
			<bean id="user" class="com.yingxs.ioc.User"></bean>
		        
		</beans>
	```
* 4.写代码测试对象创建
	```
	package com.yingxs.ioc;
	
	import org.junit.Test;
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	
	public class TestIOC {
		
		@Test
		public void testUesr(){
			//1.加载spring配置文件，根据创建对象
			ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
			
			//2.得到配置创建的对象
			User user = (User) context.getBean("user");
			System.out.println(user);
			user.add();
			
		}
	}
	
	```