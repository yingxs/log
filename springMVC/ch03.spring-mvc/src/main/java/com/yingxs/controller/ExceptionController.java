package com.yingxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

	@RequestMapping("/test1")
	public String test1() {
		System.out.println("ExceptionController的test1()");
		
		//模拟异常
		String name = null;
		name.substring(0);
		
		
		return "success";
	}
}
