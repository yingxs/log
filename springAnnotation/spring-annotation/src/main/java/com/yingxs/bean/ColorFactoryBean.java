package com.yingxs.bean;


import org.springframework.beans.factory.FactoryBean;

//创建一个spring定义的FacrotyBean
public class ColorFactoryBean implements FactoryBean<Color> {

    //返回一个Color对象，这个对象会添加到容器中
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean.....getObject.....");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    //是单例吗？
    // true代表是单例，在容器中保存一份，
    // fasle代表是多实例，每次获取都会创建一个新的对象
    public boolean isSingleton() {
        return true;
    }
}
