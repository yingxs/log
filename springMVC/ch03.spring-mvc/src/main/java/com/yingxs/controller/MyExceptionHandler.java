package com.yingxs.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {
	
	/**
	 * 异常处理方法
	 * value:该异常方法可以处理的异常类型
	 * @return
	 */
	@ExceptionHandler(value={java.lang.NullPointerException.class})
	public ModelAndView exceptionHandler(Exception ex) {
		ModelAndView mv = new ModelAndView();
		
//		mv.addObject("exception", ex.toString());
		
		StringWriter writer = new StringWriter();
		PrintWriter s = new PrintWriter(writer);
		//将异常栈中的信息暂时写入writer中
		ex.printStackTrace(s);
		
		mv.addObject("exception", writer.toString());
		
		mv.setViewName("error");
		return mv;
		
	}
	
}
