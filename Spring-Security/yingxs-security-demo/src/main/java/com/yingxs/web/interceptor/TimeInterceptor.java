package com.yingxs.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("preHandle...");
		
		System.out.println(((HandlerMethod)handler).getBean().getClass().getName() );
		System.out.println(((HandlerMethod)handler).getMethod().getName() );
		
		request.setAttribute("startTime", new Date().getTime());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle...");
		Long startTime = (Long)request.getAttribute("startTime");
		System.out.println("time interceptor 耗时:" + (new Date().getTime() - startTime));

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion...");
		
		Long startTime = (Long)request.getAttribute("startTime");
		System.out.println("time interceptor 耗时:" + (new Date().getTime() - startTime));
		// 当异常被@ControllerAdvice异常处理器处理时，获取不到异常对象
		System.out.println("ex is " + ex);

	}

}
