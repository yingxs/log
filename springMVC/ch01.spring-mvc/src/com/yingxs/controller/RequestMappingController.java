package com.yingxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("requestMapping")
public class RequestMappingController {
	/*
	 * value属性
	 */
	@RequestMapping("/test1")
	public ModelAndView test1(){
		System.out.println("RequestMappingController的test1().........");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
	
	/*
	 * method属性
	 */
	@RequestMapping(value="/test2" ,method=RequestMethod.POST)
	public ModelAndView test2(){
		System.out.println("RequestMappingController的test2().........");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
	
	/*
	 * params属性
	 */
	@RequestMapping(value="/test3" ,method=RequestMethod.GET,params={"name"})
	public ModelAndView test3(){
		//无name参数无法访问
		System.out.println("RequestMappingController的test3().........");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
	
}
