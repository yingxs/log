package com.yingxs.config;


import com.yingxs.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.yingxs.bean")
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init" , destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }


}
