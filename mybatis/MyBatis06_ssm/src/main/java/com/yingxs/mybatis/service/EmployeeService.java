package com.yingxs.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yingxs.mybatis.bean.Employee;
import com.yingxs.mybatis.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private SqlSession sqlSession; //可以批量执行的sqlSession
	
	public List<Employee> getEmps(){
		
		
		return employeeMapper.getEmps();
	}

}
