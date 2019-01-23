package com.yingxs.config;

import com.yingxs.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig02 {


    /**
     * prototype 多实例
     * singleton 单实例
     * request 同一个请求创建一个实例
     * session 同一个session创建一个实例
     */
    @Scope
    @Bean("peron")
    public Person person(){
        return new Person("张三",22);
    }

}
