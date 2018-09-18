package com.yingxs.controller;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yingxs.domain.User;
import com.yingxs.domain.UserVo;

@Controller
@RequestMapping("/param")
public class ParamterController {

	/**
	 * 1.默认参数类型
	 */
	@RequestMapping(value="/test1",method=RequestMethod.POST)
	public String test1(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		System.out.println(userName);
		System.out.println(userPass);
		
		return "success";
	}
	
	/**
	 * 2.PathVariable路径参数接收
	 */
	@RequestMapping(value="/test2/{userName}/{userPass}",method=RequestMethod.POST)
	public String test2(@PathVariable(value="userName")String userName,@PathVariable(value="userPass")String userPass) {
		System.out.println(userName);
		System.out.println(userPass);
		
		return "success";
	}
	/**
	 * 3.简单数据类型接收
	 * @RequestParam:指定参数名称
	 * 		value:指定参数名称
	 * 		required:该参数是否为必须
	 * 		 defaultValue:默认值
	 */
	@RequestMapping(value="/test3",method=RequestMethod.POST)
	public String test3(@RequestParam(value="name",required=false,defaultValue="zhangsan")String userName,int userPass) {
		//参数名称可与name一致，也可通过@RequestParam来指定
		
		System.out.println(userName);
		System.out.println(userPass+1);
		
		return "success";
	}
	
	/**
	 * 4.JavaBean类型
	 */
	@RequestMapping(value="/test4",method=RequestMethod.POST)
	public String test4(User user) {
		System.out.println(user);
		return "success";
	}
	
	/**
	 * 5.包装JavaBean类型
	 */
	@RequestMapping(value="/test5",method=RequestMethod.POST)
	public String test5(UserVo userVo) {
		System.out.println(userVo);
		return "success";
	}
	
	/**
	 * 6..绑定数组类型
	 */
	@RequestMapping(value="/test6",method=RequestMethod.POST)
	public String test6(Integer[] id) {
		System.out.println(Arrays.asList(id));
		return "success";
	}
	
	/**
	 * 7..自定义类型转换
	 */
	@RequestMapping(value="/test7",method=RequestMethod.POST)
	public String test7(Date birth) {
		System.out.println(birth);
		return "success";
	}
	
}
