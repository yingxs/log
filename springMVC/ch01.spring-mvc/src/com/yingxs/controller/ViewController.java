package com.yingxs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	/**
	 * 1.控制器方法返回void
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/test1")
	public void test1(HttpServletRequest request,HttpServletResponse response ,HttpSession session) throws ServletException, IOException{
		System.out.println("ViewController的test1()...");
		
		//转发
//		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
		//重定向
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	/**
	 * 控制器方法返回ModelAndView
	 */
	@RequestMapping("/test2")
	public ModelAndView test2(){
		ModelAndView mv = new ModelAndView();
		//如果配置了视图解析器，那么该viewName就是逻辑明后才能，否则就是物理路径
		mv.setViewName("success");
		return mv;
	}
	
	/**
	 * 控制器方法返回ModelAndView，将逻辑视图名称传入构造函数
	 */
	@RequestMapping("/test3")
	public ModelAndView test3(){
		//将逻辑视图名称放入ModelAndView构造函数中
		ModelAndView mv = new ModelAndView("success");
		//如果配置了视图解析器，那么该viewName就是逻辑明后才能，否则就是物理路径
		//mv.setViewName("success");
		mv.addObject("name", "SpringMVX");
		return mv;
	}
	
	/**
	 * 控制器方法返回字符串(转发)
	 */
	@RequestMapping("/test4")
	public String test4(Model model){
		System.out.println("ViewController的test4()方法");
		model.addAttribute("name", "Spring model");
		
		//返回视图逻辑名称
		return "success";
	}
	
	/**
	 * 控制器方法返回字符串(重定向)
	 */
	@RequestMapping("/test5")
	public String test5(){
		System.out.println("ViewController的test5()方法");
		
		return "redirect:/index.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
