package com.yingxs.config;


import com.yingxs.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类==配置文件
@Configuration       //告诉spring 这是一个配置类
@ComponentScan(value="com.yingxs",includeFilters = {
//        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class}),
//        @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes = {Service.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)
public class MainConfig {

    //给容器中注册一个bean;类型为返回值类型，id为方法名
    @Bean("person")
    public Person person99(){
        return new Person("yingxs",17);
    }
}
