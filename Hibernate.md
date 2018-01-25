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




