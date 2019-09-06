package com.yingxs.security.app;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.yingxs.security.core.social.YingxsSpringSocialConfigurer;


@Component
public class SpringSocialConfigurerPostProcess implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (StringUtils.equals(beanName, "yingxsSocialSecurityConfig")) {
			YingxsSpringSocialConfigurer configurer = (YingxsSpringSocialConfigurer) bean;
			configurer.signupUrl("/social/signUp");
			return configurer;
		}
		return bean;
	}

}
