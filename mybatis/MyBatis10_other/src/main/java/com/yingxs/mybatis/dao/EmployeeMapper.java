package com.yingxs.mybatis.dao;

import java.util.List;

import com.yingxs.mybatis.bean.Employee;

public interface EmployeeMapper {

	public abstract  Employee getEmpId(Integer id);
	
	public abstract  List<Employee> getEmps();
	
	public abstract  Long addEmp(Employee employee);
	
}
