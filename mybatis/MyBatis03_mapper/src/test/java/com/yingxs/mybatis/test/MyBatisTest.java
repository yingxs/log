package com.yingxs.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yingxs.mybatis.bean.Employee;
import com.yingxs.mybatis.dao.EmployeeMapper;
import com.yingxs.mybatis.dao.EmployeeMapperAnnotaion;

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
			
			Employee employee = mapper.getEmpId(1);
			System.out.println(mapper.getClass());
			System.out.println(employee);
		}finally {
			openSession.close();
		}
		
		
		
	}
	
	@Test
	public void test02() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapperAnnotaion mapper = openSession.getMapper(EmployeeMapperAnnotaion.class);
			Employee empId = mapper.getEmpId(1);
			System.out.println(empId);
		} finally {
			openSession.close();
		}
	}
	
	/**
	 * 	测试增删改
	 * 		1.mybatis允许增删改直接在接口中定义以下返回值类型
	 * 				Integer,Long,Boolean，void
	 * 		2.我们需要手动提交数据
	 * @throws IOException 
	 */
	@Test
	public void test03() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//1.无参获取道德的sqlSession不会自动提交
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			
			//测试添加
			Employee employee = new Employee(null, "杰克", "jack@126.com", "1");
			System.out.println("employee:"+employee);
			Long addEmp = mapper.addEmp(employee);
			System.out.println("employee:"+employee);
			System.out.println("Long:"+addEmp);
			
			//测试修改
			//boolean updateEmp = mapper.updateEmp(new Employee(1, "Tom", "jack@126.com", "1"));
			//System.out.println(updateEmp);
			//测试删除
			//mapper.deleteEmp(2);
			
			//2.手动提交
			openSession.commit();
		}finally {
			openSession.close();
		}
	}
	
	
	@Test
	public void test04() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//1.无参获取道德的sqlSession不会自动提交
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

			/*Map<String, Object> map = new HashMap<>();
			map.put("id",3);
			map.put("lastName","Tom");
			Employee employee = mapper.getEmpByMap(map);
			
			System.out.println(employee);*/
			
			List<Employee> like = mapper.getEmployeeByLastNameLike("%克%");
			for (Employee employee : like) {
				System.out.println(employee);
			}
			
		}finally {
			openSession.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
