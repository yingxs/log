package com.yingxs.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yingxs.mybatis.bean.Employee;
import com.yingxs.mybatis.dao.EmployeeMapper;

public class MyBatisTest {

	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	/**
	 * 1.获取sqlSessionFactory
	 * 		解析文件的每一个信息保存在Configuration中，包含Configuration的DefaultSessionFactory
	 * 		mappedStatement代表一个增删改查的详细信息
	 * 2.获取sqlSession对象
	 * 		返回一个DefaultSQlSession对象，包含了Executor和Configuration
	 * 		这一步创建Executor对象
	 * 3.获取接口的代理对象
	 * 		getMapper使用MapperProxyFactory创建一个MapperProxy的代理对象
	 * 		代理对象里面包含了DefaultSQlSession
	 * 4.执行增删改查方法
	 * @throws IOException
	 */
	@Test
	public void test01() throws IOException {
		
		//1.获取sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//2.获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			//3.获取接口的实现类对象
			//会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			
			Employee employee = mapper.getEmpId(1);
			System.out.println(mapper.getClass());
			System.out.println(employee);
		}finally {
			openSession.close();
		}
		
	}
	
	/**
	 * 	插件原理：
	 * 	在四大对象创建的时候
	 * 		1.每个对象创建的时候不是直接返回的，而是调用了
	 * 			interceptorChain.pluginAll(parameterHandler);	
	 *		2.获取到所有的Interceptor(插件需要实现的接口-拦截器)
	 *		3.插件机制，我们可以使用插件为目标对象对象创建一个代理对象；AOP(面向切面)
	 *			自定义插件可以为四大对象创建出代理对象，代理对象就可以拦截到四大对象的每一个执行的方法
	 
	 public Object pluginAll(Object target) {
	    for (Interceptor interceptor : interceptors) {
	      target = interceptor.plugin(target);
	    }
	    return target;
	  }
	 */
	
	/**
	 * 	插件编写
	 * 1.编写Interceptor的实现类
	 * 2.使用@Intercepts注解完成插件签名
	 * 3.将插件注册在全局配置文件中
	 */
	@Test
	public void testPlugin() {
		
	}
	
	

}
