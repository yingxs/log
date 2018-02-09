### Configuration类
> 启动hibernate程序，加载hibernate.cfg.xml配置文件

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
    



