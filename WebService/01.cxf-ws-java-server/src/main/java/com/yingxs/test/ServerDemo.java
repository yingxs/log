package com.yingxs.test;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.yingxs.service.UserService;
import com.yingxs.service.impl.UserServiceImpl;

/**
 * 	发布WebService接口
 * @author admin
 *
 */
public class ServerDemo {

	
	public static void main(String[] args) {
		//1.创建工程对象
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		//2.设置参数
		//2.1 设置访问地址(让客户端访问)
		factory.setAddress("http://localhost:9999/userService");
		//2.2设置接口类型
		factory.setServiceClass(UserService.class);
		//2.3设置实现类对象
		factory.setServiceBean(new UserServiceImpl());
		
		//3.发布接口(阻塞方式)
		factory.create();
		
		System.out.println("服务发布成功...");
		
	
	}
	
}
