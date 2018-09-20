package com.yingxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yingxs.domain.User;

@Controller
@RequestMapping("/restful")
public class RestfulController {

	/**
	 * 查询操作
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String testGet() {
		System.out.println("执行RestfulController的testGet()");
		return "success";
	}
	
	/**
	 * 新增操作
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String testPost(User user) {
		System.out.println("执行RestfulController的testPost()");
		System.out.println(user);
		return "success";
	}
	
	/**
	 * 更新操作
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public String testPut(User user) {
		System.out.println("执行RestfulController的testPut()");
		System.out.println(user);
		return "success";
	}
	/**
	 * 更新操作
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String testDelete(@PathVariable("id")Integer id) {
		System.out.println("执行RestfulController的testPut()");
		System.out.println(id);
		return "success";
	}
}
