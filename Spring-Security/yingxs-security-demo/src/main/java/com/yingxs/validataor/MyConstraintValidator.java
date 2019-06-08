package com.yingxs.validataor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.yingxs.service.HelloService;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

	
	@Autowired
	HelloService helloService;
	
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		// 校验器初始化
		System.out.println("my validataor init");
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		helloService.greeting("tom");
		System.out.println(value);
		return false;
	}

	 

}
