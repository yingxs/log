package com.yingxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView hello(){
		System.out.println("执行了hello方法");
		//把数据保存到ModelAndView（相当于保存到request域对象）
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "yingxs");
		
		//返回物理路径
		mv.setViewName("/WEB-INF/jsp/success.jsp");
		return mv;
	}
}
