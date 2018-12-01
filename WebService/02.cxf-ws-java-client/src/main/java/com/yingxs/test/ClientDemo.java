package com.yingxs.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.yingxs.domain.User;
import com.yingxs.service.UserService;

public class ClientDemo {
	
	public static void main(String[] args) {
		//1.创建工厂对象
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		
		//2.设置参数
		//2.1设置访问路径
		factory.setAddress("http://localhost:9999/userService");
		
		//2.2设置接口
		factory.setServiceClass(UserService.class);
		
		//2.3创建接口的代理类对象
		UserService userService = (UserService) factory.create();
		
		//2.4调用服务端的接口方法
		userService.saveUser(new User(1,"小张","男"));
		
		
		
		
	
	}

}
