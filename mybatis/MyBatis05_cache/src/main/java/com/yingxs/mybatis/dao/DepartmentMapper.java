package com.yingxs.mybatis.dao;

import com.yingxs.mybatis.bean.Department;

public interface DepartmentMapper {

	Department getDeptById(Integer id);
	
	Department getDeptByIdPlus(Integer id);
	
	Department getDeptByIdStep(Integer id);
	
	
}
