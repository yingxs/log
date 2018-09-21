package com.yingxs.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yingxs.domain.Customer;
import com.yingxs.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerColltroller {
	
	
	@Resource
	private CustomerService customerService;
	

	/**
	 * 用于跳转到save.jsp页面
	 * @return
	 */
	@RequestMapping("/saveUI")
	public String saveUI() {
		
		return "save";
	}
	
	/**
	 * 保存客户
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String save(Customer customer,Map<String,Object> model) {
		customerService.save(customer);
		
		model.put("msg", "添加成功");
		
		return "success";
	}
}
