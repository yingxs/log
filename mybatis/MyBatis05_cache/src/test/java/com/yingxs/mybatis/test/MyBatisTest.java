package com.yingxs.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yingxs.mybatis.bean.Department;
import com.yingxs.mybatis.bean.Employee;
import com.yingxs.mybatis.dao.DepartmentMapper;
import com.yingxs.mybatis.dao.EmployeeMapper;
import com.yingxs.mybatis.dao.EmployeeMapperAnnotaion;
import com.yingxs.mybatis.dao.EmployeeMapperDynamicSQL;
import com.yingxs.mybatis.dao.EmployeeMapperPlus;

public class MyBatisTest {

	
	
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	
	@Test
	public void testFirestLavelCache() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee e1 = mapper.getEmpId(1);
			System.out.println(e1);
			
			Employee e2 = mapper.getEmpId(1);
			System.out.println(e2);
			System.out.println(e1==e2);
			
		}finally {
			openSession.close();
		}
	}
	
	@Test
	public void testSecondLavelCache() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		SqlSession openSession2 = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);
			
			Employee emp01 = mapper.getEmpId(1);
			System.out.println(emp01);
			openSession.close();
			
			Employee emp02 = mapper2.getEmpId(1);
			System.out.println(emp02);
			openSession2.close();

		}finally {
			
		}
	}
	
	
	
	
	
	
	
	

}
