package com.yingxs.mybatis.dao;

import java.util.List;

import com.yingxs.mybatis.bean.Employee;

public interface EmployeeMapperPlus {

	Employee getEmpById(Integer id);
	Employee getEmpByIdStep(Integer id);
	Employee getEmpAndDept(Integer id);
	
	//按照部门id查询出该部门的所有员工
	List<Employee> getEmpsByDeptId(Integer deptId);
}
