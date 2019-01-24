package com.yingxs.condition;

import com.yingxs.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类
     *                 把所有需要添加到容器中的bean;调用
     *                 BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     *
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.yingxs.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.yingxs.bean.Blue");

        if(red && blue){
            //指定bean的定义信息
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean,指定bean名
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }

    }
}
