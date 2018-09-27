package com.yingxs.mybatis.dao;

import com.yingxs.mybatis.bean.Employee;

public interface EmployeeMapperPlus {

	Employee getEmpById(Integer id);
	
	Employee getEmpAndDept(Integer id);
}
