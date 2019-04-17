package com.yingxs.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.yingxs.bean.Person;
import com.yingxs.service.BookService;

// 配置类 == 配置文件

//   
/**
 * @Configuration 告诉spring这是一个配置类
 * 相当于这是一个配置文件一样
 * 
 * 
 * @ComponentScan(value="com.yingxs")  配置包扫描  相当于
 * <context:component-scan base-package="com.yingxs"></context:component-scan>
 * 
 * 
 * excludeFilters  = Filter[] 扫描的时候，按什么规则，排除什么组件
 * 		type : 定义排除规则，按注解排除，还可以按类型、正则或自定义排除
		@ComponentScan(value="com.yingxs",includeFilters = {
				@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})
		},useDefaultFilters = false)

 * includeFilters  = Filter[] 扫描的时候，按什么规则，只添加什么组件
 * 要和 useDefaultFilters = false 配置实用才能生效  禁用默认的扫描规则
 * 		type : 定义排除规则，按注解排除，还可以按类型、正则或自定义排除
 * 
 * 
 * @ComponentScans(    可用来配置多个扫描规则
			value = {
					@ComponentScan(value="com.yingxs",includeFilters = {
							@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})
					},useDefaultFilters = false)
			} 
		)
 * 
 * 
 * @author admin
 */
@Configuration
@ComponentScans(
			value = {
					@ComponentScan(value="com.yingxs",includeFilters = {
//							@Filter(type=FilterType.ANNOTATION,classes= {Controller.class}),
//							@Filter(type=FilterType.ASSIGNABLE_TYPE ,classes= {BookService.class}),
							@Filter(type=FilterType.CUSTOM ,classes= {MyTypeFilter.class})
							
					},useDefaultFilters = false)
			} 
		)
public class MainConfig {
	
	/**
	 * @Bean给容器注册一个Bean 
	 *  类型为返回值类型 id默认使用方法名作为id
	 *  
	 *  @Bean("person")指定组件的名字 也就是id
	 * @return
	 */
	@Bean("person") //默认是单实例的
	public Person person2() {
		return new Person("lisi",20);
	}

}
