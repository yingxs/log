package com.yingxs.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Aspect 告诉spring 当前类是一个切面类
 * @author admin
 *
 */
@Aspect
public class LogAspects {
	
	// 抽取公共切入点
	@Pointcut("execution(public int com.yingxs.aop.MathCalculator.*(..))")
	public void pointCut() {};
	
	// @Before在目标方法之前切入：切入表达式指定在哪个方法切入
//	@Before("public int com.yingxs.aop.MathCalculator.div(int, int)")
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.println(joinPoint.getSignature().getName()+"运行...参数列表是：{"+Arrays.asList(args)+"}");
	}
	
	@After("com.yingxs.aop.LogAspects.pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName()+"结束...");
	}
	
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result) {
		System.out.println(joinPoint.getSignature().getName()+"正常返回...运行结果是：{"+result+"}");
	}
	
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logException(JoinPoint joinPoint,Exception exception) {
		System.out.println(joinPoint.getSignature().getName()+"异常...异常信息：{"+exception+"}");
		
	}
	

}
