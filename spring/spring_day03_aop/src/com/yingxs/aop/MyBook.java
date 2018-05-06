package com.yingxs.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {
	
	//在方法上面使用注解完成增强配置
	@Before(value="execution(* com.yingxs.aop.Book.*(..))")
	public void before1(){
		System.out.println("前置......");
	}

}
