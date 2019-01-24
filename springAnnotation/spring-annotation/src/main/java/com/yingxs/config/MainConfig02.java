package com.yingxs.config;

import com.yingxs.bean.Person;
import com.yingxs.condition.LinuxCondition;
import com.yingxs.condition.WindowCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
//类中组件同一设置，满足当前条件，这个类中配置的所有bean注册才能生效
@Conditional({WindowCondition.class})
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


    /**
     * @Conditional({Condition}) : 按照一定的条件进行判断，满足条件给容器中注册bean
     * 如果系统是window 注册bill
     * 如果系统是linux 注册linus
     */
    @Conditional({WindowCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus",48);
    }





}
