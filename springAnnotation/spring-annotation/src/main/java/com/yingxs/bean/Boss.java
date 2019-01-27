package com.yingxs.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {

    private Car car;


    @Autowired
    public Boss(Car car){
        this.car=car;
        System.out.println("Boss.....有参构造器");
    }

    public Car getCar() {
        return car;
    }

    //标注在方法上，spring容器在创建当前Boss对象的时候，就会调用该方法完成赋值
    //方法使用的参数，自定义类型的值从ioc容器中获取
    //@Autowired
    public void setCar(Car car) {
        this.car = car;
    }


    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
