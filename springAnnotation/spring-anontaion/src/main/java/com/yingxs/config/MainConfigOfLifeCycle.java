package com.yingxs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.yingxs.bean.Car;

/**
 * bean的生命周期
 * 		
 * @author admin
 *
 */
@ComponentScan("com.yingxs.bean")
@Configuration
public class MainConfigOfLifeCycle {
	
	@Bean(initMethod="init",destroyMethod="destory")
	public Car car() {
		
		return new Car();
	}
	

}
