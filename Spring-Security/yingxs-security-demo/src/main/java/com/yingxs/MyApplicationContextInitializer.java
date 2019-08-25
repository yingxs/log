package com.yingxs;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/*ConfigurableApplicationContext为接口中传入的参数类型，在initialize中可以通过传入的参数执行所需要的操作*/
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("bean的个数：" + applicationContext.getBeanDefinitionCount());
        /*下面还可以用applicationContext获取bean*/
    }

}
 