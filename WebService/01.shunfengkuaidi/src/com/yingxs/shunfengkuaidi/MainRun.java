package com.yingxs.shunfengkuaidi;

import javax.xml.ws.Endpoint;

import com.yingxs.shunfengkuaidi.impl.AddressInfo;


public class MainRun {
	
	public static void main(String[] args) {
		//暴露web service接口

		//指定Web Servicede访问的地址
		String url = "http://127.0.0.1:7777/ShunFengKuaiDi";

		//指定需要暴露的接口的实现类的信息
		AddressInfo addressInfo = new AddressInfo();
		
		Endpoint.publish(url, addressInfo);
		System.out.println("========Web Service4组件暴露成功========");
		
	}
	
	
	
}
