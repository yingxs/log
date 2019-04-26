package com.yingxs.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 默认加载IOC容器中的组件，容器启动会调用无擦构造器创建对象，在进行初始化赋值操作
@Component
public class Boss {

	private Car car;
	

	// 构造器要用的组件，都是从容器中获取
	@Autowired
	public Boss(Car car) {
		super();
		this.car = car;
		System.out.println("Boss....有参构造器");
	}

	public Car getCar() {
		return car;
	}

	// 标注在方法上，Spring容器创建当前对象，就会调用方法，完成赋值
//	@Autowired
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Boss [car=" + car + "]";
	}
	
	
}
