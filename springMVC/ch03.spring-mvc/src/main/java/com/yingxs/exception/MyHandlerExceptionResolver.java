package com.yingxs.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义异常类
 * @author admin
 *
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) {

		StringWriter writer = new StringWriter();
		PrintWriter s = new PrintWriter(writer);
		ex.printStackTrace(s);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", writer.toString());
		mv.setViewName("error");
			
		return mv;
	}

}
