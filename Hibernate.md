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




