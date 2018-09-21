package com.yingxs.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	/**
	 * 	查询所有客户
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String list(Map<String,Object> model) {
			
		model.put("custList", customerService.findAll());
		
		return "list";
	}
	
	/**
	 * 	查询一个客户
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String findById(@PathVariable("id")Long custId,Map<String, Object> model) {
		Customer cust = customerService.findById(custId);
		model.put("cust", cust);
		return "edit";
	}
	
	/**
	 * 	客户修改
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public String update(Customer customer,Map<String, Object> model) {
		customerService.update(customer);
		model.put("msg", "修改成功");
		return "success";
	}
	
	
}
