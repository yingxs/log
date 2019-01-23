package com.yingxsx.test;

import com.yingxs.config.MainConfig;
import com.yingxs.config.MainConfig02;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

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
