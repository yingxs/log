package com.yingxs.mybatis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yingxs.mybatis.bean.Employee;
import com.yingxs.mybatis.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@RequestMapping("/getemps")
	public String emps(Map<String,Object> map) {
		
		List<Employee> emps = empService.getEmps();
		map.put("allEmps", emps);
		return "list";
	}
	
}
