package com.yingxs.shunfengkuaidi;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;

import com.yingxs.shunfengkuaidi.impl.AddressInfo;


public class MainRun {
	
	public static void main(String[] args) {
		//暴露web service接口

		//指定Web Servicede访问的地址
		String url = "http://127.0.0.1:5555/ShunFengKuaiDi";

		//指定需要暴露的接口的实现类的信息
		AddressInfo addressInfo = new AddressInfo();
		
		EndpointImpl endpointImpl =  (EndpointImpl)Endpoint.publish(url, addressInfo);
		
		//通过endpointImpl来增加拦截器 日志输入输出拦截器(是CXF中默认自带的拦截器)
		endpointImpl.getInInterceptors().add(new LoggingInInterceptor());//日志输出拦截器
		endpointImpl.getOutInterceptors().add(new LoggingOutInterceptor());//日志输入拦截器
		
		
		System.out.println("========Web Service6组件暴露成功========");
		
	}
	
	
	
}
