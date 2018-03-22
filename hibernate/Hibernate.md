# Hibernate
> hibernate是一个对JDBC代码封装的ORM的持久层框架

### 什么是ORM
> ORM，Object-Relational-Mapping，对象关系映射，ORM思想，建立起Java对象和关系数据库之间的关系


#### ORM的优点
* java开发人员可以很轻松的操作对象，间接操作数据库
* 可以更加方便封装数据
* 不用编写SQL语句

### Hibernate的HelloWorld
> 需求：模拟商城的客户注册(客户添加)

* 导入Hibernate的Jar包
    * 导入hibernate目录下的lib/requires/下所有的jar包
* 在数据库建立表
    ```
    create table t_customer(
        c_id int primary key auto_increment,
        c_name varchar(20),
        c_gender char(1),
        c_age int,
        c_level varchar(20)
    );
    ```
* 编写实体类
    ```
    package com.yingxs.domain;
    import java.io.Serializable;
    /**
     * 客户实体类
     * @author admin
     *
     */
    public class Customer implements Serializable {
    	private Integer id;
    	private String name;
    	private String gender;
    	private Integer age;
    	private String level;
    	public Integer getId() {
    		return id;
    	}
    	public void setId(Integer id) {
    		this.id = id;
    	}
    	public String getName() {
    		return name;
    	}
    	public void setName(String name) {
    		this.name = name;
    	}
    	public String getGender() {
    		return gender;
    	}
    	public void setGender(String gender) {
    		this.gender = gender;
    	}
    	public Integer getAge() {
    		return age;
    	}
    	public void setAge(Integer age) {
    		this.age = age;
    	}
    	public String getLevel() {
    		return level;
    	}
    	public void setLevel(String level) {
    		this.level = level;
    	}
    }
    ```
* 编写*.hbm.xml文件(对象关系映射文件，参考hibernate-core-5.0.7.Final.jar/org.hibernate/hibernate-mapping-3.0.dtd 重点)
    * 建议规则要求：
        * 文件名称：实体名称.hbm.xml
        * 文件存放的位置：和实体类存放到同一目录
        ```
        <?xml version="1.0" encoding="utf-8"?>
        <!DOCTYPE hibernate-mapping PUBLIC 
            "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
            "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
            
        <hibernate-mapping>
        	<!--
        		表示要映射的类
        		name:类名
        		table:表名
        		
        	  -->
        	<class name="com.yingxs.domain.Customer" table="t_customer">
        		<!-- 主键 -->
        		<id name="id" column="c_id">
        			<generator class="native"></generator>
        		</id>
        		<!-- 其他属性 -->
        		<property name="name" column="c_name"></property>
        		<property name="gender" column="c_gender"></property>
        		<property name="age" column="c_age"></property>
        		<property name="level" column="c_level"></property>
        	</class>
        </hibernate-mapping>
    
        ```
* 编写hibernate.cfg.xml文件(hibernate的核心配置文件,参考hibernate-core-5.0.7.Final.jar/org.hibernate/hibernate-configuration-3.0.dtd和hibernate-release-5.0.7.Final/project/etc/hibernate.properties)
    * 建议规则要求 
        * 文件名称: hibernate.cfg.xml
        * 存放位置：项目的src下
        ```
        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE hibernate-configuration PUBLIC
        	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
        	
        <hibernate-configuration>
        	<!-- 连接数据库的相关参数 -->
        	<session-factory>
        		<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        		<property name="hibernate.connection.url">jdbc:mysql://localhost:3308/hibernate</property>
        		<property name="hibernate.connection.username">root</property>
        		<property name="hibernate.connection.password">123456</property>
        		
        		<!-- hibernate方言 -->
        		<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        		
        		<!-- *.hbm.xml -->
        		<mapping resource="com/yingxs/domain/Customer.hbm.xml" />
        		
        	</session-factory>
        </hibernate-configuration>
        ```
* 编写测试代码
```
package com.yingxs.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yingxs.domain.Customer;

/**
 * hibernate的helloworld
 * @author admin
 *
 */
public class Demo1 {
	
	@Test
	public void test1(){
		Customer customer = new Customer();
		customer.setName("老王");
		customer.setAge(40);
		customer.setGender("男");
		customer.setLevel("VIP客户");
		
		
		
		//1.读取hibernate.cfg.xml文件
		Configuration cfg = new Configuration();
		cfg.configure();
		//2.创建SessionFactory工厂
		SessionFactory factory = cfg.buildSessionFactory();
		//3.创建Session事务
		Session session = factory.openSession();
		//4.开启事务,打开事务并返回事务对象
		Transaction tx = session.beginTransaction();
		//5.执行添加操作
		session.save(customer);
		//6.提交事务
		tx.commit();
		//7.关闭资源
		session.close();
		
	}

}

```

### hibernate.cfg.xml配置详解
* 数据库连接参数
    * hibernate.connection.driver_class
    * hibernate.connection.url
    * hibernate.connection.username
    * hibernate.connection.psssword
    * hibernate.dialect
* hibernate扩展参数
    * hibernate.show_sql 布尔值，是否输出hibernate生成的sql语句 
    * hibernate.format_sql 布尔值，是否格式化hibernate输出的sql语句 
    * hibernate.hbm2ddl_auto hibernate维护表的方式
        *  create : 每次hibernate都会新的生成表结构
        *  update ： 会维护表结构，没有表的时候创建，有表的时候就不创建
* 映射信息

### *.hbm.xml对象映射文件详解
> *.hbm.xml这个文件是hibernate对象关系映射文件

* hibernate-mapping标签：根标签
    * package属性：类所在的包 
* class标签： 代表映射一个类
    * 属性
        * name : 类的限定名(包名+类名)，如果根标签有了package属性，那么name只写类名即可
        * table: 表名
    * 子标签
        * id标签：代表映射一个表的主键字段 (必须)
            * 属性
                * name属性 ：类的属性名称，属性名称指定的是实体里面的getter和setter方法的名称，而不是私有成员名称。 
                * column属性：表的主键字段名称
            * 子标签
                * generator标签：主键策略
        * property标签：代表映射的是一个普通字段
            * 属性
                * name属性 ：类的属性名称，属性名称指定的是实体里面的getter和setter方法的名称，而不是私有成员名称。 
                * column属性：表的字段名称

## hibernate核心接口详解
> hibernate核心API一共有6个


### Configuration类
> 启动hibernate程序，加载hibernate.cfg.xml配置文件
> 
* cfg.configure();真正加载hibernate.cfg.xml配置文件
* cfg.configure(new File("./src/hbm.cfg.xml"));当配置文件名称不是默认名称的时候，使用此API

注意：
* 通常情况下，Configuration对象只会创建一个对象，Configuration对象是单例的

### SessionFactory接口
> SessionFactory加载连接数据库，扩展参数，映射信息，通过这些映射信息帮助我们创建Session对象

注意：
* 通常，一个项目只需要创建一个SessionFactory即可！

### Session接口
> 用于操作对象从而来操作数据库

* session常用方法
    *  save(); 保存对象
    *  update(); 更新对象
    *  delete(); 删除对象
    *  get() 查询一个对象
* Session是一个线程不安全的，在项目中需要创建多个Session对象，一个线程就创建一个Session对象

### Transaction接口
> 用于执行事务操作

* 常用方法
    *  commit(); 提交事务
    *  rollback(); 回滚事务

### Query接口
> 用于执行HQL查询

### Criteria接口
> 用于执行基于对象的查询(QBC查询)

### hibernate工具类
```
package com.yingxs.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate工具类
 * @author admin
 *
 */
public class HibernateUtils {
	
	private static Configuration cfg = null;
	private static SessionFactory factory = null;
	
	static{
		cfg = new Configuration();
		cfg.configure();
		factory = cfg.buildSessionFactory();
	}
	
	public static Session getSession(){
		return factory.openSession();
	}
	
}

```

### 使用session进行增删改查
* session接口常用的方法
	* save(Object obj) 保存对象
	* uopdate(Ibject obj) 更新对象
	* saveOrUpdate(Object obj) 添加或修改对象
	* delete(Object obj) 删除对象 
	* get(Class clz,Serialize id): 获取对象
	* load(Class clz,Serialize id): 获取对象

### generator主键生成策略
* 三类策略
    * 由数据库维护
        * identity
            * 利用数据库自增长的能力，例如mysql的auto_increment 
        * sequence
            * 利用数据库序列生成的能力，例如oracle的sequence  
        * native
            * 本地策略，由hibernate自动根据不同的数据库选择最优策略
    * 由hibernate维护
        * uuid
            * 生成32位16进制的无序字符串 
        * increment
            * 生成递进的数值类型(每次+1)
    * 由开发者维护
        * assigned 

### 对象关系映射之一对多映射
> 需求：客户与订单之间的关系


#### 关系(数据库)设计
* 结论：一对多关系在数据库中是依靠外键维护的
```
--客户表--
create table t_customer( 
    id int primary key auto_increment,
    name varchar(20),
    gender char(1)
);
```
```
--订单表--
 create table t_order(
    id int primary key auto_increment,
    orderno varchar(20)
    ,product_name varchar(20),
    cust_id int,
    constraint order_customer_fk foreign key(cust_id) references t_customer(id)
);
	
```
#### 对象设计
* 结论：一对多关系在对象层面是依靠JavaBean和Set集合的
```
package com.yingxs.one2many;

import java.util.HashSet;
import java.util.Set;
/**
 * 客户对象(一方)
 * @author admin
 *
 */
public class Customer {
	private Integer id;
	private String name;
	private String gender;
	
	//关联订单
	private Set<Order> orders = new HashSet<Order>();
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 create table t_customer( id int primary key auto_increment,name varchar(20),gender char(1));
	 */
}

```
```

package com.yingxs.one2many;
/**
 * 订单对象(多方)
 * @author admin
 *
 */
public class Order {
	private Integer id;
	private String orderno;
	private String productName;
	//关联客户
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	  create table t_order(id int primary key auto_increment,orderno varchar(20),product_name varchar(20),cust_id int,constraint order_customer_fk foreign key(cust_id) references t_customer(id));
	 */
}

```
#### 映射配置
* Customer.hbm.xml 客户对象映射
```
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-mapping PUBLIC 
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">


<hibernate-mapping package="com.yingxs.one2many">
	<!-- 
		name:类名
		table:表名
	 -->
	<class name="Customer" table="t_customer">
		<!-- 主键 -->
		<id name="id" column="id">
			<generator class="native"></generator>
		</id>
		<!-- 其他属性 -->
		<property name="name" column="name"></property>
		<property name="gender" column="gender"></property>
		
		<!-- 一对多配置 -->
		<set name="orders">
			<!-- 外键字段名称 -->
			<key column="cust_id"></key>
			<one-to-many class="Order"/>
		</set>
	</class>

</hibernate-mapping>    
    

```
* Order.hbm.xml 订单对象映射
```
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-mapping PUBLIC 
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">


<hibernate-mapping package="com.yingxs.one2many">
	<!-- 
		name:类名
		table:表名
	 -->
	<class name="Order" table="t_order">
		<!-- 主键 -->
		<id name="id" column="id">
			<generator class="native"></generator>
		</id>
		<!-- 其他属性 -->
		<property name="orderno" column="orderno"></property>
		<property name="productName" column="product_name"></property>
		
		<!-- 多对一 -->
		<many-to-one name="customer" class="Customer" column="cust_id" ></many-to-one>
	</class>

</hibernate-mapping>    
    

```
#### cascade和inverse配置详解

##### cascade配置
> 级联操作，就是操作一个对象的时候，相同时操作它的关联对象

```
<!-- 一对多配置 -->
<set name="orders" cascade="save-update">
	<!-- 外键字段名称 -->
	<key column="cust_id"></key>
	<one-to-many class="Order"/>
</set>
```
级联保存：save-update
级联删除：delete
级联保存与删除：all
```
/**
 * 简单的一对多的保存操作
 */
@Test
public void test3(){
	//准备数据
	//需求：一个客户 两张订单
	Customer cust = new Customer();
	cust.setName("小王");
	cust.setGender("男");
	
	Order o1 = new Order();
	o1.setOrderno("2018013001");
	o1.setProductName("《那晚》");
	
	Order o2 = new Order();
	o2.setOrderno("2018013002");
	o2.setProductName("《空姐秘史》");
	
	Session session = HibernateUtils.getSession();
	Transaction tx = session.beginTransaction();
	
	//建立一对多单项关联
	cust.getOrders().add(o1);
	cust.getOrders().add(o2);

	
	session.save(cust);

	
	tx.commit();
	session.close();
}
```
```
/**
 * 级联删除操作
 * ps:
 * 		1.如果没有级联删除，那么在删除客户的时候，会把订单表的cust_id外键值设置为null
 * 		2.有了级联删除，再删除客户的时候，会同时把该客户的所有订单删除
 */
@Test
public void test4(){
	
	
	Session session = HibernateUtils.getSession();
	Transaction tx = session.beginTransaction();
	
	Customer cust = session.get(Customer.class, 2);
	session.delete(cust);

	
	tx.commit();
	session.close();
}

```

##### inverse配置
> 是否把关联关系的维护权反转(放弃)

flase 不放弃
true 放弃

* 结论
    * 通常在一对多的关联配置中，多方是无法放弃关系维护权，建议放弃一方的维护权，意味着在一方加上inverse="true"配置


### 对象关系映射之一对多映射
> 需求：用户与角色是多对多的关系！

#### 数据库设计
* 结论：多对多关系是依靠中间表维护的

#### 对象设计
```
package com.yingxs.many2many;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/*
 * 用户
 * 
 */
public class User implements Serializable {
	private Integer id;
	private String name;
	
	//关联角色
	private Set<Role> roles = new HashSet<Role>(); 
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}



package com.yingxs.many2many;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 */
public class Role implements Serializable {
	private Integer id;
	private String name;
	
	//关联用户
	private Set<User> users = new HashSet<User>();
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}



```

#### 映射配置
* 用户方 User.hbm.xml
```
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-mapping PUBLIC 
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">


<hibernate-mapping package="com.yingxs.many2many">
	<!-- 
		name:类名
		table:表名
	 -->
	<class name="User" table="t_user">
		<!-- 主键 -->
		<id name="id" column="id">
			<generator class="native"></generator>
		</id>
		<!-- 其他属性 -->
		<property name="name" column="name"></property>
		
		<!-- 多对多映射 
			table:中间表名
		-->
		<set name="roles" table="t_user_role">
			<!-- 当前方在中间表的外键 -->
			<key column="user_id"></key>
			<!-- 
				class:set集合中类型，也就是对方的类型
				column:对方在中间表的外键 
			-->
			<many-to-many class="Role" column="role_id"></many-to-many>
		</set>
	</class>

</hibernate-mapping>    
    

```

* 角色方 Role.hbm.xml
```
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-mapping PUBLIC 
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">


<hibernate-mapping package="com.yingxs.many2many">
	<!-- 
		name:类名
		table:表名
	 -->
	<class name="Role" table="t_role">
		<!-- 主键 -->
		<id name="id" column="id">
			<generator class="native"></generator>
		</id>
		<!-- 其他属性 -->
		<property name="name" column="name"></property>
		
		<!-- 多对多映射 
			table:中间表名
		-->
		<set name="users" table="t_user_role" inverse="true">
			<!-- 当前方在中间表的外键 -->
			<key column="role_id"></key>
			<!-- 
				class:set集合中类型，也就是对方的类型
				column:对方在中间表的外键 
			-->
			<many-to-many class="User" column="user_id"></many-to-many>
		</set>
	</class>

</hibernate-mapping>    
    

```
##### 添加操作(无级联)
```
/**
	 * 添加操作
	 */
	@Test
	public void test1(){
		/**
		 * 需求：建立两个用户，两个角色
		 */
		User u1 = new User();
		u1.setName("小苍");
	
		User u2 = new User();
		u2.setName("小泽");
		
		Role r1 = new Role();
		r1.setName("超级管理员");
		
		Role r2 = new Role();
		r2.setName("普通管理员");
		
		//建立双向关系
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		r1.getUsers().add(u1);
		r2.getUsers().add(u1);

		u2.getRoles().add(r2);
		r2.getUsers().add(u2);
		
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		
		tx.commit();
		session.close();
	}
```
#### 演示操作
```
package com.yingxs.many2many;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yingxs.utils.HibernateUtils;

/**
 * 演示多对多操作
 */
public class Demo3 {
	
	/**
	 * 添加操作
	 */
	@Test
	public void test1(){
		/**
		 * 需求：建立两个用户，两个角色
		 */
		User u1 = new User();
		u1.setName("小苍");
	
		User u2 = new User();
		u2.setName("小泽");
		
		Role r1 = new Role();
		r1.setName("超级管理员");
		
		Role r2 = new Role();
		r2.setName("普通管理员");
		
		//建立双向关系
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		r1.getUsers().add(u1);
		r2.getUsers().add(u1);

		u2.getRoles().add(r2);
		r2.getUsers().add(u2);
		
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * 查询操作
	 */
	@Test
	public void test2(){
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		//需求：查询一个用户，以及该用户的所有角色
		User user = session.get(User.class, 1);
		Set<Role> roles = user.getRoles();
		System.out.println("当前用户为："+user.getName());
		System.out.println("角色为：");
		for (Role role : roles) {
			System.out.print(role.getName()+",");
		}
		tx.commit();
		session.close();
	}
	
	/**
	 * 查询操作2
	 */
	@Test
	public void test3(){
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		//需求：查询一个角色，以及该角色的所有用户
		Role role = session.get(Role.class, 2);
		Set<User> users = role.getUsers();
		System.out.println("当前角色为："+role.getName());
		System.out.println("当前角色的用户有：");
		for (User user : users) {
			System.out.println(user.getName()+",");
		}
		
		
		session.close();
	}
	/**
	 * 级联添加操作
	 */
	@Test
	public void test4(){
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		User u = new User();
		u.setName("老王");
		
		Role r = new Role();
		r.setName("基础管理员");
		
		//级联添加操作
		u.getRoles().add(r);
		session.save(u);
		tx.commit();
		session.close();
	}
	/**
	 * 级联删除操作 
	 */
	@Test
	public void test5(){
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 3);
		session.delete(user);
		/**
		 * 删除用户，同时还删除了中间表和用户相关的数据，还删除了对应的角色数据
		 * 在实际开发中，多对多关系中通常不使用级联删除！！！
		 */
		tx.commit();
		session.close();
	}
}


```
### 对象关系映射之一对一映射
> 需求：公民和身份证是一对一关系

#### 数据库设计
* 唯一外键关联设计 
* 主键关联

#### 对象设计
* 公民对象Person
```
package com.yingxs.one2one_fk;

import java.io.Serializable;

public class Person implements Serializable {
	private Integer id;
	private String name;
	
	//关联身份证号
	private Card card;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
}

```
* 身份证号对象Card
```
package com.yingxs.one2one_fk;

import java.io.Serializable;

public class Card implements Serializable {
	private Integer id;
	private String name;
	
	//关联公民
	private Person person;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}

```

#### 映射配置
* 唯一外键关系映射
    * 公民方映射
    ```
    
    
    <?xml version="1.0" encoding="utf-8"?>
    <!DOCTYPE hibernate-mapping PUBLIC 
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
    
    
    <hibernate-mapping package="com.yingxs.one2one_fk">
    	<!-- 
    		name:类名
    		table:表名
    	 -->
    	<class name="Person" table="t_person_fk">
    		<!-- 主键 -->
    		<id name="id" column="id">
    			<generator class="native"></generator>
    		</id>
    		<!-- 其他属性 -->
    		<property name="name" column="name"></property>
    		
    		<!-- 一对多 -->
    		<one-to-one name="card" class="Card"></one-to-one>
    		
    	</class>
    
    </hibernate-mapping>    
        
    
    ```
    * 身份证号方的映射
    ```
    <?xml version="1.0" encoding="utf-8"?>
    <!DOCTYPE hibernate-mapping PUBLIC 
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
    
    
    <hibernate-mapping package="com.yingxs.one2one_fk">
    	<!-- 
    		name:类名
    		table:表名
    	 -->
    	<class name="Card" table="t_card_fk">
    		<!-- 主键 -->
    		<id name="id" column="id">
    			<generator class="native"></generator>
    		</id>
    		<!-- 其他属性 -->
    		<property name="name" column="name"></property>
    		
    		<!-- 唯一外键(一对一) -->
    		<many-to-one name="person" class="Person" column="person_id" update="true" />
    		
    		
    	</class>
    
    </hibernate-mapping>    
        

    ```
* 主键关联
    * 公民方配置
    ```
    <?xml version="1.0" encoding="utf-8"?>
    <!DOCTYPE hibernate-mapping PUBLIC 
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
    
    
    <hibernate-mapping package="com.yingxs.one2one_pk">
    	<!-- 
    		name:类名
    		table:表名
    	 -->
    	<class name="Person" table="t_person_pk">
    		<!-- 主键 -->
    		<id name="id" column="id">
    			<generator class="native"></generator>
    		</id>
    		<!-- 其他属性 -->
    		<property name="name" column="name"></property>
    		
    		<!-- 一对多 -->
    		<one-to-one name="card" class="Card"></one-to-one>
    		
    	</class>
    
    </hibernate-mapping>    
    
    ```
    * 身份证号码方配置
    ```
    <?xml version="1.0" encoding="utf-8"?>
    <!DOCTYPE hibernate-mapping PUBLIC 
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
        
    <hibernate-mapping package="com.yingxs.one2one_pk">
    	<!-- 
    		name:类名
    		table:表名
    	 -->
    	<class name="Card" table="t_card_pk">
    		<!-- 主键 -->
    		<id name="id" column="id">
    			<generator class="native"></generator>
    		</id>
    		<!-- 其他属性 -->
    		<property name="name" column="name"></property>
    		
    		<!-- 主键关联(一对一) -->
    		<one-to-one name="person" class="Person" constrained="true"/>
    		
    	</class>
    
    </hibernate-mapping>    
        

    ```
    
## 本章学习目标
> 基本对象查询，HQL查询，QBC查询，本地SQL查询


### 基本对象查询
> 需求：客户和订单的关系

* get()
* load()


### HQL查询
> HQL，hibernate查询语言(hibernate Query Language),语法和sql语法非常类似


```
package com.yingxs.test;


import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示HQL的查询（单表查询）
 * 1.全表查询
 * 2.别名查询
 * 3.条件查询
 * 4.具名查询
 * 5.分页查询
 * 6.查询排序
 * 7.聚合查询
 * 8.投影查询
 * @author admin
 *
 */

public class Demo2 {

	/**
	 * 全表查询
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 别名查询
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select o from Order o");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 条件查询
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order where orderno = '201709070001'");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 条件查询2
	 */
	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order where orderno = ?");
		query.setParameter(0, "201709070001");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	/**
	 * 具名查询
	 */
	@Test
	public void test5(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order where orderno = :orderno");
		query.setParameter("orderno", "201709070001");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 分页查询
	 */
	@Test
	public void test6(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order");
		//设置起始行，从0开始
		query.setFirstResult(0);
		//设置查询的条数
		query.setMaxResults(2);
		
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	/**
	 * 查询排序
	 */
	@Test
	public void test7(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order order by id desc");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 聚合查询
	 */
	@Test
	public void test8(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select count(*) from Order");
		/**
		//语法一:
		List<Long> list = query.list();
		Long count = list.get(0);
		System.out.println(count);
		*/
		
		Long count = (Long)query.uniqueResult();
		System.out.println(count);
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 投影查询 查询局部字段
	 */
	@Test
	public void test9(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select orderno,productName from Order");
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		tx.commit();
		session.close();
		
	}
	
	
	/**
	 * 投影查询2
	 */
	@Test
	public void test10(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select new com.yingxs.domain.Order(orderno,productName) from Order");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order.getOrderno()+"\t"+order.getProductName());
		}
		tx.commit();
		session.close();
		
	}
	
}

```


#### 多表查询

* 内连接查询 inner join
* 左连接查询 left join
* 右连接查询 right join

```
package com.yingxs.test;


import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示HQL的查询（多表查询）
 * 1.内连接查询(inner join)
 * 2.左链接查询(left join)
 * 3.右连接查询(right join)
 *
 */

public class Demo3 {

	/**
	 * 内连接查询
	 * 只会显示满足条件的记录
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//需求：显示客户名称和订单产品名称
		Query query = session.createQuery("select c.name,o.productName from Customer c inner join c.orders o");
		List<Object[]> list = query.list();
	
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		tx.commit();
		session.close();
		
	}
	
	
	
	/**
	 * 左连接查询
	 * 左边的表会全部显示
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//需求：显示客户名称和订单产品名称
		Query query = session.createQuery("select c.name,o.productName from Customer c left join c.orders o");
		List<Object[]> list = query.list();
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		tx.commit();
		session.close();
		
	}
	
	
	
	/**
	 * 右连接查询
	 * 右边的表会全部显示
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//需求：显示客户名称和订单产品名称
		Query query = session.createQuery("select c.name,o.productName from Order o right join o.customer c");
		List<Object[]> list = query.list();
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		tx.commit();
		session.close();
		
	}
	
	
	
}

```
### QBC查询
> QBC查询，Query By Criteria 使用Criteria对象进行查询,是面向对象的查询方式

```
package com.yingxs.test;


import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示Criteria的查询（单表查询）
 * 1.全表查询
 * 2.条件查询
 * 3.分页查询
 * 4.查询排序
 * 5.聚合查询
 * 6.投影查询
 * @author admin
 *
 */

public class Demo2 {

	/**
	 * 全表查询
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Customer.class);
		List<Customer> list = ce.list();
		for (Customer customer : list) {
			System.out.println(customer.getName());
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 条件查询
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		//添加查询条件 orderno = '20170907003'
		ce.add( Restrictions.eq("orderno", "201709070003") );
		List<Order> list = ce.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 条件查询2(多条件)
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//添加查询条件 orderno like '%2017%' and productName like '%JavaWeb%'
		ce.add( Restrictions.and(Restrictions.like("orderno", "%2017%"), Restrictions.like("productName", "%JavaWeb%")));
		List<Order> list = ce.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 分页查询
	 */
	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		//分页查询
		ce.setFirstResult(0);	//起始行
		ce.setMaxResults(2);	//查询行数
		
		
		List<Order> list = ce.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 查询排序
	 */
	@Test
	public void test5(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//排序 order by id desc
		ce.addOrder( org.hibernate.criterion.Order.desc("id"));
		
		List<Order> list = ce.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 聚合查询
	 */
	@Test
	public void test6(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//查询总记录数 select count (id)
		//ce.setProjection(Projections.count("id"));
		
		//查询id中的最大值
		ce.setProjection(Projections.max("id"));
		
		Integer count = (Integer)ce.uniqueResult();
		System.out.println(count);
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * 投影查询
	 */
	@Test
	public void test7(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//投影操作
		ProjectionList pList = Projections.projectionList();
		pList.add(Property.forName("orderno"));
		pList.add(Property.forName("productName"));
		
		ce.setProjection(pList);
		
		List<Object[]> list = ce.list();
		System.out.println(list);
		
		/*for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}*/
		
		tx.commit();
		session.close();
		
	}
	
}

```


### 本地SQl查询
> 直接执行SQl语句

```
package com.yingxs.test;


import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示本地SQl的查询
 */

public class Demo5 {

	//以对象数组的形式封装
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		
		SQLQuery sqlQuery = session.createSQLQuery("select * from t_order");
		List<Object[]> list = sqlQuery.list();
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		tx.commit();
		session.close();
		
	}
	
	
	//以JavaBean对象的形式封装
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		
		SQLQuery sqlQuery = session.createSQLQuery("select * from t_order");
		sqlQuery.addEntity(Order.class);
		List<Order> list = sqlQuery.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
		
	}
	
}

```
# 本章的学习目标
* Hibernate对象的三种状态
* Hibernate的一级缓存与快照机制
* 一级缓存的管理
* 延迟加载策略
* 抓取策略
* 整合durid连接池
* Hibernete的二级缓存



### Hibernate对象的三种状态
> 在Hibernate程序运行过程中，一个对象会存在以下三种状态

* 临时状态：没有对象OID值，没有被session管理
* 持久化状态：有对象OID值，已经被session管理
* 游离状态：有对象OID值，已经脱离了session的管理
```
@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();	//这时的c对象没有OID值，没有被session管理，这时c对象就是临时状态的对象
		c.setName("老王");
		
		session.save(c);			//这时的c对象有OID的值，被session管理 ，属于持久态对象
		System.out.println(c.getId());
		
		tx.commit();
		session.close();
		
		System.out.println(c);			//这时的c对象有OID的值，没有被session管理 ，属于游离态对象
		
	}
```
> 重点：在Hibernate的三种对象状态中，最为重要的状态是：持久态。持久态对象可以直接影响数据库的数据


### Hibernate的一级缓存和快照机制
#### Hibernate的一级缓存
> 什么是Hibernate的一级缓存？其实就是session对象的缓存,说白了就是Session内部的一个Map集合。他的作用就是为了减少程序和数据库的交互次数，从而提高程序执行的性能

```
    /**
     * 使用代码来证明hibernate一级缓存的存在
     */
    @Test
    public void test2(){
    	Session session = HibernateUtil.getSession();
    	Transaction tx = session.beginTransaction();
    	
    	//第一次查询
    	Customer c1 = session.get(Customer.class, 1);
    	System.out.println(c1);
    	//第二次查询
    	Customer c2 = session.get(Customer.class, 1);
    	System.out.println(c2);
    	
    	
    	tx.commit();
    	session.close();
    }
```

#### Hibernate的快照机制
> 快照机制，其实就是Session内部的一个Map集合，用于备份数据库的数据，用于和以及缓存的数据进行对比，以便实现持久态对象更新数据库的效果

为什么持久态对象可以影响数据库？
* 因为Hiibernate的Session内部存在以及缓存和快照机制

* commit方法的代码：
    * 执行session.flush()方法，这个方法对比一级缓存和快照去的数据，如果发现有差异，就会产生SQL语句
    * Hibernate就会发送SQl语句到数据库执行
    * Hibernate执行提交事务的方法，数据提交到数据库
    * 把快照的数据进行更新

    
#### 一级缓存的管理
> 如果持久态对象不在一级缓存中，不能更新数据

把对象移出一级缓存的方法
* session.evict(object) 把一个对象移出一级缓存
* session.clear() 把一级缓存中的所有对象移出

```
package com.yingxs.test;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * 演示一级缓存的管理
 * @author admin
 *
 */

public class Demo3 {


	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.get(Customer.class, 1);		//cust是持久态对象，在一级缓存中
		cust.setName("老王");
		
		//把cust对象移出一级缓存
//		session.evict(cust);
		
		
		//清空 一级缓存
		session.clear();
		
		tx.commit();
		session.close();
	}
	
}

```
#### Hibernate的延迟加载策略
> 延迟加载是为了减少程序和数据库的访问次数，提高程序的执行性能

* 延迟加载的执行机制
     * 在查询一个对象的时候 ，不会去数据库查询对象的属性或者其关联的数据
     * 在需要使用到数据的属性或者关联数据的时候才会去查询数据库
     * 即，按需加载

##### 类级别(属性)的延迟加载
load():只有load方法才支持类级别的延迟加载(可修改)
get():get方法不支持类级别的延迟加载
```
/***
 * 类级别的延迟加载
 */

@Test
public void test1(){
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	/*
	//get():get方法不支持类级别的延迟加载
	Customer cust = session.get(Customer.class, 1);
	System.out.println(cust.getName());
	*/
	
	
	
	//load():load():只有load方法才支持类级别的延迟加载
	Customer cust = session.load(Customer.class, 1);
	System.out.println(cust.getName());
	
	
	tx.commit();
	session.close();
}
	
```

##### 关联级别(属性)的延迟加载
> 以一对多为例

```
/**
 * 关联级别的延迟加载( 一对多: <set/> )
 * 修改一对多的延迟加载配置：
 * 		<set name="orders"  inverse="true" lazy="false">
 */
@Test
public void test2(){
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	
	Customer cust = session.get(Customer.class, 1);
	//关联订单
	System.out.println(cust.getOrders().size());	//延迟加载的
	
	
	tx.commit();
	session.close();
}
	
```
多对一
```

	/**
	 * 
	 * 关联级别的延迟加载( 多对一: <many-to-one/> )
	 * 修改多对一的延迟加载配置：
	 * 		<many-to-one name="customer" class="Customer" column="cust_id" lazy="false" ></many-to-one>
	 */
	@Test 
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order order = session.get(Order.class, 1);
		System.out.println(order.getCustomer().getName());		//非延迟加载
		
		tx.commit();
		session.close();
	}
	
```

#### Hibernate抓取策略
> 抓取策略，是为了改变SQL语句查询的方式，从而提高SQL语句查询的效率(优化SQL语句),以一对多为例

##### 一方:<set/>
```
/***
 * 一方：<set/>
 * fetch="select" ：默认情况下，执行两条SQL语句
 * fetch="join"	: 把两条SQL语句合并成左外连接查询(效率高一点，但是如果配置了join延迟加载失效)
 */

@Test
public void test1(){
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	
	Customer cust = session.get(Customer.class, 1);
	System.out.println(cust.getOrders());
	
	tx.commit();
	session.close();
}


/***
 * 一方：<set/>
 * 需求：在查询多个一方(客户)的数据，关联查询多方(订单)的数据，如果fetch的配置是select的时候，一共发出n+1条sql语句
 * fetch="subselect"	: 使用子查询进行关联查询
 */

@Test
public void test2(){
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	
	Query query = session.createQuery("from Customer");
	List<Customer> list = query.list();
	for (Customer customer : list) {
		System.out.println(customer.getOrders().size());
	}
	
	tx.commit();
	session.close();
}
```

##### 多方:<many-to-one/>
```
/***
 * 多方：<many-to-one/>
 * fetch="select" ：默认情况下，执行两条SQL语句（支持延时加载）
 * fetch="join"	: 把两条SQL语句合并成左外连接查询(效率高一点，但是如果配置了join延迟加载失效)
 * 
 */

@Test
public void test3(){
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	
	Order order = session.get(Order.class, 1);
	System.out.println(order.getCustomer());
	
	tx.commit();
	session.close();
}
```
##### 整合连接池
* 导包
    * c3p0-0.9.2.1.jar                      c3p0核心包
    * mchange-commons-java-0.2.3.4.jar      c3p0依赖包
    * hibernate-c3p0-5.0.7.Final.jar        hibernate与c3p0整合包
* 在hibernate.cfg.xml添加整合配置
    ```
	<!-- 整合c3p0 -->
	<property name="hibernate.connection.provider_class">org.hibernate.c3p0.internal.C3P0ConnectionProvider</property>
	
	<!-- c3p0详细配置 -->
	<property name="c3p0.min_size">10</property>
	<property name="c3p0.max_size">20</property>


    ```
```
package com.yingxs.test;


import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import com.yingxs.utils.HibernateUtil;

/**
 * 演示连接池的整合是否成功
 * @author admin
 *
 */

public class Demo6 {

	
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();

		session.doWork(new Work(){
			@Override
			public void execute(Connection connection) throws SQLException {

				System.out.println(connection);
			}
		});
		
		session.close();
	}
	
}

```

#### Hibernate二级缓存

* Hibernate的一级缓存：
    * 就是Session对象的缓存，而session对象在每次操作之后都会关闭，那么一级缓存就会丢失
    * 结论：一级缓存只用于一次业务操作内的缓存


* Hibernate的二级缓存：
    * 就是SessionFactory的缓存，二级缓存和SessionFactory对象的生命周期是一致的，SessionFactory不销毁，那么二级缓存的数据就不会丢失 
    * 结论：二级缓存可以用于多次业务操作

##### 注意
* Hibernate一级缓存默认是开启的，而且无法关闭
* Hibernate二级缓存默认是关闭的，如果需要可以开启，而且需要引入第三方的缓存工具，例如EhCache等



#### 使用Hibernate的二级缓存
* 导入Ehcache
* 在hibernate.cfg.xml中配置二级缓存
    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE hibernate-configuration PUBLIC
    	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
    	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
    
    <hibernate-configuration>
    <session-factory>
    	<!-- 1.连接数据库的参数 -->
    	<property name="hibernate.connection.driver_class">
    		com.mysql.jdbc.Driver
    	</property>
    	<property name="hibernate.connection.url">
    		jdbc:mysql://localhost:3308/hibernate
    	</property>
    	<property name="hibernate.connection.username">root</property>
    	<property name="hibernate.connection.password">123456</property>
    	
    	<!-- 整合c3p0 -->
    	<property name="hibernate.connection.provider_class">org.hibernate.c3p0.internal.C3P0ConnectionProvider</property>
    	<!-- c3p0详细配置 -->
    	<property name="c3p0.min_size">10</property>
    	<property name="c3p0.max_size">20</property>
    
    
    
    
    	<!-- hibernate方言 -->
    	<property name="hibernate.dialect">
    		org.hibernate.dialect.MySQLDialect
    	</property>
    
    	<!-- hibernate扩展参数 -->
    	<property name="hibernate.show_sql">true</property>
    	<property name="hibernate.format_sql">true</property>
    	<property name="hibernate.hbm2ddl.auto">update</property>
    
    	<!-- 开启hibernate的二级缓存 -->
    	<property name="hibernate.cache.use_second_level_cache">true</property>
    	<!-- 引入Ehcache的工具 -->
    	<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
    
    
    	<!-- *.hbm.xml文件 -->
    	<mapping resource="com/yingxs/domain/Customer.hbm.xml" />
    	<mapping resource="com/yingxs/domain/Order.hbm.xml" />
    	
    	<!-- 需要缓存哪个类 -->
    	<class-cache usage="read-only" class="com.yingxs.domain.Customer"/>
    
    </session-factory>
    </hibernate-configuration>
    ```

### hibernate隔离级别的配置

#### 并发事务会存在的问题：
* 脏读：一个事务读到另一个事务并发的未提交的数据
* 不可重复读：一个事务读到了另一个并发事务的updata的数据
* 幻读：一个事务读到了另一个并发事务的insert数据

#### 数据库的隔离级别
> 数据库的隔离级别可以防止以上三种现象

* read uncommited：不能防止脏读，不可重复读，幻读
* read committed：防止脏读，但是不能防止不可重复读，幻读(Oracle默认)
* repeatable read：防止脏读，不可重复读，不能防止幻读(mysql默认)
* serializable：防止脏读，不可重复读，幻读


#### Hibernate通过配置修改数据的隔离级别
* 1; read uncommited
* 2: read committed
* 4: repeatable read
* 8: serializable

```
    <!-- 修改HIbernate的隔离级别 -->
	<property name="hibernate.connection.isolation">4</property>
```

## 使用ThreadLocal管理Session
> 为什么要使用TheadLocal管理Session，在业务层无法使用事务进行管理Session

### 配置HIbernate得的ThreadLcoal
* 修改hibernate.cfg.xml
    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE hibernate-configuration PUBLIC
    	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
    	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
    
    <hibernate-configuration>
    <session-factory>
    	<!-- 1.连接数据库的参数 -->
    	<property name="hibernate.connection.driver_class">
    		com.mysql.jdbc.Driver
    	</property>
    	<property name="hibernate.connection.url">
    		jdbc:mysql://localhost:3308/hibernate
    	</property>
    	<property name="hibernate.connection.username">root</property>
    	<property name="hibernate.connection.password">123456</property>
    	
    	<!-- 整合c3p0 -->
    	<property name="hibernate.connection.provider_class">org.hibernate.c3p0.internal.C3P0ConnectionProvider</property>
    	<!-- c3p0详细配置 -->
    	<property name="c3p0.min_size">10</property>
    	<property name="c3p0.max_size">20</property>
    
    	<!-- hibernate方言 -->
    	<property name="hibernate.dialect">
    		org.hibernate.dialect.MySQLDialect
    	</property>
    
    	<!-- hibernate扩展参数 -->
    	<property name="hibernate.show_sql">true</property>
    	<property name="hibernate.format_sql">true</property>
    	<property name="hibernate.hbm2ddl.auto">update</property>
    
    	<!-- 开启hibernate的二级缓存 -->
    	<property name="hibernate.cache.use_second_level_cache">true</property>
    	<!-- 引入Ehcache的工具 -->
    	<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
    
    	<!-- 让Session能够被ThreadLocal管理  -->
    	<property name="hibernate.current_session_context_class">thread</property>
    	
    	
    	<!-- *.hbm.xml文件 -->
    	<mapping resource="com/yingxs/domain/Customer.hbm.xml" />
    	<mapping resource="com/yingxs/domain/Order.hbm.xml" />
    	
    	<!-- 需要缓存哪个类 -->
    	<class-cache usage="read-only" class="com.yingxs.domain.Customer"/>
    
    </session-factory>
    </hibernate-configuration>
    ```
### 修改HibernateUtiil工具类
```
	
public static Session getSession(){
//		return factoy.openSession();
	return factoy.getCurrentSession();
	
}
```

Dao层代码
```
package com.yingxs.Threadlocation;

import org.hibernate.Session;
import com.yingxs.domain.Customer;
import com.yingxs.utils.HibernateUtil;

public class CustomerDao {
	

	
	public void save(Customer cust){
		Session session = HibernateUtil.getSession();
		session.save(cust);
		//不能关闭Session
//		session.close();
	}

}

```
Service层代码
```
package com.yingxs.Threadlocation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yingxs.domain.Customer;
import com.yingxs.utils.HibernateUtil;

public class CustomerService {
	private CustomerDao dao = new CustomerDao();
	
	public void save(Customer c1,Customer c2){
		Session session = HibernateUtil.getSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		
		try {
			dao.save(c1);
//			int i = 100/0;		//这时候发生错误
			dao.save(c2);		
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			System.out.println("发生错误，事务已经回滚");
		}
	}

}

```
### hibernate隔离级别的配置

#### 并发事务会存在的问题：
* 脏读：一个事务读到另一个事务并发的未提交的数据
* 不可重复读：一个事务读到了另一个并发事务的updata的数据
* 幻读：一个事务读到了另一个并发事务的insert数据

#### 数据库的隔离级别
> 数据库的隔离级别可以防止以上三种现象

* read uncommited：不能防止脏读，不可重复读，幻读
* read committed：防止脏读，但是不能防止不可重复读，幻读(Oracle默认)
* repeatable read：防止脏读，不可重复读，不能防止幻读(mysql默认)
* serializable：防止脏读，不可重复读，幻读


#### Hibernate通过配置修改数据的隔离级别
* 1; read uncommited
* 2: read committed
* 4: repeatable read
* 8: serializable

```
    <!-- 修改HIbernate的隔离级别 -->
	<property name="hibernate.connection.isolation">4</property>
```

### JPA与hibernate的关系
> JPA是接口，是规范，Hibernate是实现，Hibernate框架从3.2开始完成支持JPA开发，这里只是用到了JPA的注解开发

### JPA注解的基础入门
#### 使用JPA映射类
```
@Entity
@Table(name="t_customer")
public class Customer  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gander")
	private String gender;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
```
#### 修改配置文件
```
<class-cache usage="read-only" class="com.yingxs.domain.Customer"/>
```


### @Transient注解的使用
> @Transient注解，用于给实体类添加临时属性(不映射到数据库中)

```
@Transient			//临时字段，不反映到数据库中
	public Boolean getIsMarried() {
		return isMarried;
	}
	public void setIsMarried(Boolean isMarried) {
		this.isMarried = isMarried;
	}
```

### JPA的主键策略
> JPA的主键策略，没有HIbernate的主键策略丰富

```
@GeneratedValue(strategy=GenerationType.IDENTITY)
```
* 常见的主键策略
    * IDENTITY:利用数据库的自增长能力，适合mysql
    * SEQUENCE：利用数据库的序列机制，适合Oracle
    * TABLE：利用JPA生成表维护主键值
    * AUTO：自动选择一种合适的

    
### JPA的一对多关系映射
> 需求：客户与订单是一对多的关系

Customer:
```
package com.yingxs.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="t_customer")
public class Customer  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gander")
	private String gender;
	
	@Transient			//临时字段，不反映到数据库中
	private Boolean isMarried;
	
	//关联多方
	@OneToMany(targetEntity=Order.class,mappedBy="customer")
	private Set<Order> orders = new HashSet<Order>();
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Boolean getIsMarried() {
		return isMarried;
	}
	public void setIsMarried(Boolean isMarried) {
		this.isMarried = isMarried;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}

```

Order；
```
package com.yingxs.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="orderno")
	private String orderno;
	
	//关联客户
	@ManyToOne(targetEntity=Customer.class)
	@JoinColumn(name="cust_id")
	private Customer customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}

```

### JPA的多对多关系映射
> 需求：用户和角色是多对多的关系

User：
```
package com.yingxs.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="user_name")
	private String userName;
	
	//关联角色
	@ManyToMany(targetEntity=Role.class)
	//@JoinTable:用于映射中间表
	//joinColumns:当前方在中间表的外键字段名称
	//inverseJoinColumns:对方在中间表的外键字段名称
	@JoinTable(
			name="t_user_role",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<Role>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}

```

Order:
```
package com.yingxs.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_role")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="role_name")
	private String roleName;
	
	//关联用户
	@ManyToMany(targetEntity=User.class,mappedBy="roles")
	private Set<User> users = new HashSet<User>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}

```
测试代码
```
@Test
public void test1(){
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	
	User u1 = new User();
	u1.setUserName("小泽");
	
	User u2 = new User();
	u2.setUserName("小苍");
	
	Role r1 = new Role();
	r1.setRoleName("视觉总监");
	Role r2 = new Role();
	r2.setRoleName("动作指导");
	
	
	u1.getRoles().add(r1);
	r1.getUsers().add(u1);
	
	u2.getRoles().add(r2);
	r2.getUsers().add(u2);
	
	
	session.save(u1);
	session.save(u2);
	session.save(r1);
	session.save(r2);
	
	tx.commit();
	
	
}

```

### JPA的一对一关系映射
> 公民与身份证是一对一的关系


Person:
```
package com.yingxs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	//关联身份证
	@OneToOne(targetEntity=Person.class,mappedBy="person")
	private Card card;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
}

```

Card:
```
package com.yingxs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_card")
public class Card {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="card_no")
	private String cardno;
	
	
	//关联公民
	@OneToOne(targetEntity=Card.class)
	@JoinColumn(name="person_id")
	private Person person;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCardno() {
		return cardno;
	}


	public void setCardno(String cardno) {
		this.cardno = cardno;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}
}

```



















