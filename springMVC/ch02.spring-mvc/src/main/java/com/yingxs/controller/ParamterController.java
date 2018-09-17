package com.yingxs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/param")
public class ParamterController {

	/**
	 * 1.默认参数类型
	 */
	@RequestMapping(value="test1",method=RequestMethod.POST)
	public String test1(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		System.out.println(userName);
		System.out.println(userPass);
		
		return "success";
	}
	
}
