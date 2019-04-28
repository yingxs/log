package com.yingxs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.yingxs.aop.LogAspects;
import com.yingxs.aop.MathCalculator;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

	@Bean //业务逻辑类加入到容器中
	public MathCalculator calculator() {
		return new MathCalculator();
	}
	
	//切面类加入到容器中
	@Bean
	public LogAspects logAspects() {
		return new LogAspects();
	}
	
}
