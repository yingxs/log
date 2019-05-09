package com.yingxs.springboot.controller;

import com.yingxs.springboot.dao.EmployeeDao;
import com.yingxs.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    // 查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        // thymeleaf默认就会拼接字符串
        // classpath:/templates/返回值.html
        return "emp/list";

    }

}
