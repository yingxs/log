package com.yingxs.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断操系统是否是linux
public class LinuxCondition implements Condition {


    /**
     *
     * @param conditionContext 判断条件能使用的上下文(环境)
     * @param annotatedTypeMetadata 注释信息
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //判断是否是linux系统
        //1.获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2.获取到类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //3.获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //4.获取bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        //判断容器中bean的注册情况，也可以给容器中注册bean
        boolean defintion = registry.containsBeanDefinition("person");

        String property = environment.getProperty("os.name");
        if(property.contains("linux")){
            return true;
        }

        return false;
    }
}
