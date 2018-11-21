package com.yingxs.it.shunFengKuaiDi;

import javax.xml.ws.Endpoint;

import com.yingxs.it.shunFengKuaiDi.impl.AddressInfo;

public class Run {
	public static void main(String[] args) {
		//暴露web service接口
		
		//指定Web Servicede访问的地址
		String url = "http://127.0.0.1:8888/ShunFengKuaiDi";
	
		//指定需要暴露的接口的实现类的信息
		AddressInfo addressInfo = new AddressInfo();
		
		Endpoint.publish(url, addressInfo);
		System.out.println("========Web Service组件暴露成功========");
		
	}
	
}
