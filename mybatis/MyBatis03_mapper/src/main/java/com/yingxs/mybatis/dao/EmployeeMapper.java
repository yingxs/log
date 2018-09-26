package com.yingxs.mybatis.dao;

import com.yingxs.mybatis.bean.Employee;

public interface EmployeeMapper {

	public abstract  Employee getEmpId(Integer id);
	public abstract Long addEmp(Employee employee);
	public abstract boolean updateEmp(Employee employee);
	public abstract void deleteEmp(Integer id);
	
}
