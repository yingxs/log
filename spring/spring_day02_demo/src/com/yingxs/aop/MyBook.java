package com.yingxs.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {
	
	public void before1(){
		System.out.println("前值增强......");
	}
	public void after1(){
		System.out.println("后置增强......");
	}
	
	//环绕通知
	public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		//方法之前执行
		System.out.println("方法之前.....");
		
		//执行被增强的方法
		proceedingJoinPoint.proceed();
		
		//方法之后执行
		System.out.println("方法之后.....");
		
	}
}
