package com.yingxs.bean;

import org.springframework.beans.factory.FactoryBean;

// 创建一个Spring定义的FactoryBean
public class ColorFactoryBean  implements FactoryBean<Color>{

	// 返回一个Color对象，这个对象会添加到容器中
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean....getObject......");
		return new Color();
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

	// 是否单例，true为单例,false为多实例
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
