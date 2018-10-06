package com.yingxs.mybatis.dao;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
/**
 * 	插件签名：
 * 		告诉MyBatis当前插件拦截哪个对象的哪个方法
 * @author admin
 *
 */
@Intercepts(
		{
			@Signature(type=StatementHandler.class,method="parameterize",args=java.sql.Statement.class)
		}
		)
public class MyFirstPlugin implements Interceptor {

	/**
	 * intercept:拦截
	 * 		拦截目标对象的目标方法的执行
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		System.out.println("插件1--拦截方法  :"+invocation.getMethod());
		//偷梁换柱 表面查询1号员工，实际查询三号员工
		Object target = invocation.getTarget();
		System.out.println("拦截到的目标对象："+target);
		//获取StatementHandler==>ParameterHandler==>parameterObject
		MetaObject metaObject = SystemMetaObject.forObject(target);
		Object value = metaObject.getValue("parameterHandler.parameterObject");
		System.out.println("SQL语句的参数是："+value);
		//修改sql语句要用的参数
		metaObject.setValue("parameterHandler.parameterObject", 3);
		//放行 执行目标方法
		Object proceed = invocation.proceed();
		//返回执行后的返回值
		return proceed;
	}

	/**
	 * plugin:
	 * 		包装目标对象，包装：就是为目标对象创建一个代理对象
	 */
	@Override
	public Object plugin(Object target) {
		System.out.println("插件1--插件包装对象  :"+target);
		//	可以借助plugin的wrap方法来使用当前的Interceptor包装我们的目标对象
		Object wrap = Plugin.wrap(target, this);
		//	返回当前target创建的动态代理
		return wrap;
	}

	
	/**
	 * setProperties：
	 * 	将插件注册时的属性信息设置进来
	 */
	@Override
	public void setProperties(Properties properties) {
		System.out.println("插件1的配置信息 :"+properties);
	}

}
