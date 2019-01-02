package com.yingxs.springboot.config;

import com.yingxs.springboot.service.HelloService;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 指明当前类是一个配置类，就是来期待之前的Spring配置文件
 * 在配置文件中<bean></bean>添加组件
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中,容器中这个组件的默认ID就是方法名
    public HelloService helloService(){
        System.out.println("配置类@Bean向容器中添加组件了....");
        return new HelloService();
    }
}
