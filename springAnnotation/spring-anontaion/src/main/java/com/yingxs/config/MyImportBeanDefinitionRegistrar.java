package com.yingxs.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.yingxs.bean.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata；当前（配置）类的注解信息
	 * BeanDefinitionRegistry ：BeanDefinition注册类
	 * 		将需要添加到容器中的bean：调用
	 * 		BeanDefinitionRegistry.registerBeanDefinitions 手工注册进来
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		boolean definition = registry.containsBeanDefinition("com.yingxs.bean.Red");
		boolean definition2 = registry.containsBeanDefinition("com.yingxs.bean.Blue");
		if (definition && definition2) {

			// 指定bean定义信息（bean的类型....）
			RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
			// 注册一个Bean，指定bean名
			registry.registerBeanDefinition("rainBow", beanDefinition);
		}
	
	}

}
