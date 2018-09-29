package com.yingxs.mybatis.dao;

import java.util.List;

import com.yingxs.mybatis.bean.Employee;

public interface EmployeeMapperDynamicSQL {
	//	携带了哪个字段条件就带上这个字段的值
	List<Employee> getEmpsByConditionIf(Employee employee);
	List<Employee> getEmpsByConditionTrim(Employee employee);
}
