package com.yingxs.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yingxs.mybatis.bean.Employee;

public interface EmployeeMapper {

	public abstract List<Employee> getEmployeeByLastNameLike(String lastName);
	
	public abstract  Employee getEmpByMap(Map<String,Object> map);
	public abstract  Employee getEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
	
	public abstract  Employee getEmpId(Integer id);
	public abstract Long addEmp(Employee employee);
	public abstract boolean updateEmp(Employee employee);
	public abstract void deleteEmp(Integer id);
	
}
