package com.yingxs.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

@org.springframework.context.annotation.Configuration
public class MyBatisConfig {


    // 自定义mybatis的配置规则
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                // 开启驼峰命名
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }

}
