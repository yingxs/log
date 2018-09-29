package com.yingxs.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.yingxs.mybatis.bean.Employee;


public interface EmployeeMapperAnnotaion {

	@Select("select * from tbl_employee where id=#{id} ")
	public abstract  Employee getEmpId(Integer id);
}
