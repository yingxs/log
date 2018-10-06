package com.yingxs.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yingxs.mybatis.bean.Employee;
import com.yingxs.mybatis.dao.EmployeeMapper;

public class MyBatisTest {

	/**
	 * 1.根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
	 *     有数据源一些运行环境的信息
	 * 2.sql映射文件：配置了每一个sql，以及sql的封装规则
	 * 3.将SQL配置文件引入全局配置文件
	 * 		4.写代码
	 * 			1.根据全局配置文件得到sqlSessionFactory
	 * 			2.使用sqlSession工厂，获取到sqlSession对象执行增删改查
	 * 			  一个session就是代表和数据库的一次会话，用完就关闭
	 * 			3.使用sql的唯一标识来告诉MyBatis执行哪个sql
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//2.获取sqlsession实例，能直接执行已经映射的sql语句
		//参数一：sql的唯一标识
		//参数二：执行sql要用的参数
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			Employee employee = openSession.selectOne("com.yingxs.mybatis.EmployeeMapper.selectEmp", 1);
			System.out.println(employee);
		} finally  {
			openSession.close();
		}
	}
	
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	//接口式编程
	/**
	 * 1.接口式编程
	 * 原生：  			Dao 	===> 	DaoImpl
	 * mybatis		Mapper  ===>	xxMapper.xml
	 * 
	 * 2.sqlSession代表和数据库的一次会话，用完必须关闭
	 * 3.SqlSession和Connection一样，都是非线程安全的，每次应该去获取新的对象
	 * 4.mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象
	 * 		(将接口和xml进行绑定)
	 * 		EmployeeMapper empMapper = sqlSession.getMapper(EmployeeMapper.class);
	 * 5.两个重要的配置文件
	 * 		全局配置文件：数据库连接信息，事务管理器信息，系统运行环境
	 * 		sql映射文件：保存了每一个sql语句的映射信息
	 * 			将SQl抽取出来
	 * 
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
			//第param1页 每页param2条
			Page<Object> page = PageHelper.startPage(9, 2);
			
			List<Employee> emps = mapper.getEmps();
			
			//第二个可选参数为连续显示多少页码
			PageInfo<Employee> info = new PageInfo<Employee>(emps,3);
			
			for (Employee employee : emps) {
				System.out.println(employee);
			}
			/*
			System.out.println("当前页码:"+page.getPageNum());
			System.out.println("总记录数:"+page.getTotal());
			System.out.println("每页记录数:"+page.getPageSize());
			System.out.println("共:"+page.getPages()+"页");
			*/
			
			System.out.println("当前页码:"+info.getPageNum());
			System.out.println("总记录数:"+info.getTotal());
			System.out.println("每页记录数:"+info.getPageSize());
			System.out.println("共:"+info.getPages()+"页");
			System.out.println("是否第一页:"+info.isIsFirstPage());
			System.out.println("是否最后一页:"+info.isIsLastPage());
			System.out.println("连续显示的页码：");
			int[] nums = info.getNavigatepageNums();
			for (int i : nums) {
				System.out.print(i+" ");
			}
			
		}finally {
			openSession.close();
		}
		
	}
	
	
	@Test
	public void testBatch() throws IOException {
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//可以执行批量操作的sqlSession
		SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			//循环执行即可
			for(int i = 0 ;i < 10000 ; i++) {
				mapper.addEmp(new Employee("a","b","1"));
			}
			openSession.commit();
		}finally {
			openSession.close();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
