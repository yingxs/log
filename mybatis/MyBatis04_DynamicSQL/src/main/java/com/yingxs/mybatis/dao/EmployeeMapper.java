package com.yingxs.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.yingxs.mybatis.bean.Employee;

public interface EmployeeMapper {

	//多条记录封装成一个map；Map<Integer,Employee>键是这条记录的主键，值是封装后的javaBean
	//指定mybatis封装这个map的时候使用Employee的哪个属性作为map的key
	@MapKey("lastName")
	Map<String,Employee> getEmpBylastNameLikeReturnMap(String lastName);
	
	//返回一条记录的map：key就是列名，值就是对应的值
	Map<String,Object> getEmpIdReturnMap(Integer id);

	List<Employee> getEmployeeByLastNameLike(String lastName);

	Employee getEmpByMap(Map<String, Object> map);

	Employee getEmpByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);

	Employee getEmpId(Integer id);

	Long addEmp(Employee employee);

	boolean updateEmp(Employee employee);

	void deleteEmp(Integer id);

}
