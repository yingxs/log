package com.yingxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
	
	@RequestMapping("/test1")
	public String test1() {
		System.out.println("3.InterceptorController的test方法");
		return "success";
	}

}
