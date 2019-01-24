package com.yingxsx.test;

import com.yingxs.bean.Person;
import com.yingxs.config.MainConfig;
import com.yingxs.config.MainConfig02;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);


    @Test
    public void test03(){
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        //获取运行环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量中的值
        //获取操作系统名称
        String property = environment.getProperty("os.name");
        System.out.println(property);

        for(String name : namesForType){
            System.out.println(name);
        }
        System.out.println("===========");

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);

    }



    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        //查看IOC容器中的所有组件
        for (String name:definitionNames) {
            System.out.println(name);
        }
    }
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        //查看IOC容器中的所有组件
        for (String name:definitionNames) {
            System.out.println(name);
        }
    }
}
