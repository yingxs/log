package com.yingxs.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yingxs.mybatis.bean.Employee;

public interface EmployeeMapperDynamicSQL {
	//	携带了哪个字段条件就带上这个字段的值
	List<Employee> getEmpsByConditionIf(Employee employee);
	
	List<Employee> getEmpsByConditionTrim(Employee employee);
	
	List<Employee> getEmpsByConditionChoose(Employee employee);
	
	List<Employee> getEmpsByConditionForeach(@Param("ids")List<Integer> ids);
	
	void updateEmp(Employee employee);
	
	void addEmps(@Param("emps")List<Employee> emps);
	
}
