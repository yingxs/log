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



### 配置文件没有提示问题
## Spring的bean管理(xml方式)
> 在spring里面通过配置文件创建对象

### bean实例化的三种实现方式
* 1.使用类的无参构造创建(重点)
	```
	<bean id="user" class="com.yingxs.ioc.User"></bean>
	```
	* 类中没有无参构造，会出现异常
* 2.使用静态工厂创建
	* 创建静态的方法，返回类对象
	```
	<!-- 使用静态工厂创建对象 -->
	<bean id="bean2" class="com.yingxs.bean.Bean2Factory" factory-method="getBean2"></bean> 
	```
	* bean2.java
	```
	package com.yingxs.bean;
	
	public class Bean2 {
		
		public void add(){
			System.out.println("bean2.....");
		}
	
	}
	
	```
	* Bean2Factory.java
	```
	package com.yingxs.bean;
	
	public class Bean2Factory {
		public static Bean2 getBean2(){
			return new Bean2();
		}
	
	}
	
	```
	* TestIOC.java
	```
	package com.yingxs.bean;
	
	import org.junit.Test;
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	
	public class TestIOC {
		
		@Test
		public void testUesr(){
			//1.加载spring配置文件，根据创建对象
			ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
			
			//2.得到配置创建的对象
			Bean2 bean2 =  (Bean2) context.getBean("bean2");
			System.out.println(bean2);
			bean2.add();
			
		}
	}
	
	```
* 3.使用实例工厂创建
	* xml
	 ```
		<!-- 使用实例工厂创建对象 -->
		<!-- 创建工厂对象 -->
		<bean id="Bean3Factory" class="com.yingxs.bean.Bean3Factory" ></bean> 
		<bean id="bean3" factory-bean="Bean3Factory" factory-method="getBean3"></bean> 
	 ``` 
	* Bean3.java
	```
	package com.yingxs.bean;
	
	public class Bean3 {
		
		public void add(){
			System.out.println("bean3.....");
		}
	
	}
	
	```
	* Bean3Factory.java
	```
	package com.yingxs.bean;
	
	public class Bean3Factory {
		
		public  Bean3 getBean3(){
			return new Bean3();
		}
	
	}
	
	```
	* @Test
	
	```
	@Test
	public void testUesr2(){
		//1.加载spring配置文件，根据创建对象
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		
		//2.得到配置创建的对象
		Bean3 bean3 =  (Bean3) context.getBean("bean3");
		System.out.println(bean3);
		bean3.add();
		
	}
	```
### Bean标签的常见属性
* id属性
	* 名称，不能包含特殊字符，根据id得到配置对象 
* class属性
	* 创建的对象所在的类的全路径 
* name属性
	* 功能上和id属性是一样的，id不能包含特殊字符，但是在name属性里面可以包含特殊字符 
* scope属性
	* singleton 默认值，单例的
	* prototype 多例的
	* request   spring创建一个Bean对象，将对象存入request中
	* session   spring创建一个Bean对象，讲对象存入session中
	* globalSession     WEB项目中，应用在porlet环境，如果没有porlet环境那么globalSession就相当于session 

### 属性注入
> 创建对象的时候，向类里面的属性设置值


#### 属性注入的三种方式
* 使用set方法注入
* 使用有参构造注入
* 使用接口注入
##### 在spring支持前两种方式
* set方法注入（重点）
* 有参构造注入

### 使用有参构造注入属性
* xml
```
<!-- 使用有参构造注入属性 -->
<bean id="demo" class="com.yingxs.property.PropertyDemo1" >
	<constructor-arg name="username" value="小王小马"></constructor-arg>
</bean>
```
* PropertyDemo1.java
```
package com.yingxs.property;

public class PropertyDemo1 {
	private String username;

	public PropertyDemo1(String username) {
		this.username = username;
	}
	public void test1() {
		System.out.println("demo1...."+username);
	}
	
}

```
* @Test
```
@Test
public void testDemo1(){
	//1.加载spring配置文件，根据创建对象
	ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
	
	//2.得到配置创建的对象
	PropertyDemo1 demo1 = (PropertyDemo1) context.getBean("demo");
	demo1.test1();
	
}
```
### 使用setr方法注入属性
* xml
```
<!-- 使用set方法注入属性 -->
<bean id="book" class="com.yingxs.property.Book">
	<!-- 注入属性值 -->
	<property name="bookname" value="《三体》"></property>
</bean>
```
* Book.java
```
package com.yingxs.property;

public class Book {
	private String bookname;

	//set方法
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	public void demobook() {
		System.out.println("book......"+bookname);
	}
	
}

```
* @Test
```
@Test
public void testDemo2(){
	//1.加载spring配置文件，根据创建对象
	ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
	
	//2.得到配置创建的对象
	Book book = (Book) context.getBean("book");
	book.demobook();
	
}
```
### 注入对象类型属性（重点）
#### 创建service类和dao类
> 在service得到dao对象
* service
```
package com.yingxs.ioc;

public class UserService {
	public  void add() {
		System.out.println("service.....add()");
		//在service里面得到dao类对象，才能调用dao里面的方法
		//UserDao dao = new UserDao();
		//dao.add();
	}

}

```
* dao
```
package com.yingxs.ioc;

public class UserDao {
	
	public  void add() {
		System.out.println("dao.....add()");
	}
}

```
#### spring注入对象类型属性具体实现过程
* 1.在service里面把dao作为类型属性
* 2.生成dao类型属性的set方法
```
package com.yingxs.ioc;

public class UserService {
	
	//1.定义dao类型属性
	private UserDao userDao;
	//2.生成set方法
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public  void add() {
		System.out.println("service.....add()");
		//在service里面得到dao类对象，才能调用dao里面的方法
		//UserDao dao = new UserDao();
		//dao.add();
		userDao.add();
	}


}


```
```
package com.yingxs.ioc;

public class UserDao {
	
	public  void add() {
		System.out.println("dao.....add()");
	}
}

```
* 3.配置文件中注入关系
```
<!--注入对象类型属性 -->
<bean id="userDao" class="com.yingxs.ioc.UserDao" ></bean>

<bean id="userService" class="com.yingxs.ioc.UserService" >
	<!-- 注入dao对象 
		name:service里面的类属性名称
		ref：引用的dao对象id
	-->
	<property name="userDao" ref="userDao"></property>
</bean>
```

### P名称空间注入
* xml 
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- p名称空间注入 -->
	<bean id="person" class="com.yingxs.property.Person" p:pname="yingxs" ></bean>
        
</beans>
```
* Person
```
package com.yingxs.property;

public class Person {
	private String pname;

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public void test1(){
		System.out.println("person..."+pname);
	}

}

```
* @Test
```
@Test
public void testDemo3(){
	//1.加载spring配置文件，根据创建对象
	ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
	
	//2.得到配置创建的对象
	Person person = (Person) context.getBean("person");
	person.test1();
	
}
```

### 注入复杂类型
* 数组
* list集合
* map集合
* properties类型

```
<!-- 注入复杂类型属性值 -->
<bean id="person" class="com.yingxs.property.Person"  >
	<!-- 数组 -->
	<property name="arrs" > 
		<list>
			<value>小王</value>
			<value>小吗</value>
			<value>小怂</value>
		</list>
	</property>
	<!-- list -->
	<property name="list">
		<list>
			<value>大王</value>
			<value>大妈</value>
			<value>大宋</value>
		</list>
	</property>
	
	<!-- map -->
	<property name="map">
		<map>
			<entry key="aa" value="AA"></entry>
			<entry key="bb" value="BB"></entry>
			<entry key="cc" value="CC"></entry>
			<entry key="dd" value="DD"></entry>
		</map>
	</property>
	<!-- properties -->
	<property name="properties">
		<props>
			<prop key="diverclass">com.mysql.jdbc.Driver</prop>
			<prop key="username">root</prop>
		</props>
		
	</property>
</bean>
```
### IOC和DI的区别
* IOC：控制反转，把对象创建交给spring进行配置
* DI：依赖注入，向类里面的属性设置值
* 关系：依赖注入不能单独存在，需要在ioc的基础之上完成操作

### Spring整合到web项目
> spring在执行过程中，需要通过new对象来读取配置文件，虽然功能上可以实现，但是效率很低

#### 实现思想
> 把加载配置文件和创建对象的过程，在服务器启动的时候完成

#### 实现原理
* 1.ServletContext对象
* 2.监听器
* 3.实现过程
	*  在服务器启动的时候，为每一个项目创建一个ServletContext对象
	*  在ServletContext对象创建时候，使用监听器可以监听到ServletContext对象在什么时候创建
	*  使用监听器监听到ServletContext对象创建的时候
	*  加载Spring配置文件，把配置文件配置的对象创建
	*  把创建出来的对象放到ServletContext域对象里面(setAttribute方法)
	*  获取对象的时候，到ServletContext域获得(getAttribute方法)