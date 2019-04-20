package com.yingxs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.yingxs.bean.Color;
import com.yingxs.bean.ColorFactoryBean;
import com.yingxs.bean.Person;
import com.yingxs.bean.Red;
import com.yingxs.condition.LinuxCondition;
import com.yingxs.condition.WindowsCondition;

/**
 * @Conditional({WindowsCondition.class})
 * 当@Conditional注解位于类上时，当满足条件时，该类配置的所有注册的bean才会生效
 * @author admin
 *
 */
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})  //@Import导入组件，id默认是组件的全类名
public class MainConfig2 {
	
	@Lazy
	@Scope
	@Bean("person")
	public Person person() {
		System.out.println("创建bean");
		return new Person("张三",25);
	}
	
	
	@Bean("bill")
	public Person person01() {
		return new Person("Bill Gates",62);
	}
	
	@Conditional({LinuxCondition.class})
	@Bean("linus")
	public Person person02() {
		return new Person("linus",48);
		
	}
	
	
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
	
	
	
	
	

}
