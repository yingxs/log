package com.yingxs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.yingxs.bean.Person;

@Configuration
public class MainConfig2 {
	
	@Lazy
	@Scope
	@Bean("person")
	public Person person() {
		System.out.println("创建bean");
		return new Person("张三",25);
	}

}
