package com.yingxs.tianmao.interceptor;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OutInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	private String account;
	private String password;
	
	public OutInterceptor(String account, String password) {
		//指定什么时候修改soap包，Phase.Phase.PREPARE_SEND：在发送请求至服务器之前修改Soap包
		super(Phase.PREPARE_SEND);
		this.account = account;
		this.password = password;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 客户端调用方法与服务器交互的时候，会将soap包封装成SoapMessage的实例，可以通过操作message来改Soap包
	 * 在Soap中增加权限认证的信息
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		// TODO Auto-generated method stub
		
		//获取所有的Header节点
		List<Header> headers = message.getHeaders();
		
		//创建Document实例，通过Document实例来操作XML片段
		Document documrnt = DOMUtils.createDocument();
		
		//创建auth节点
		Element element = documrnt.createElement("auth");
		
		//创建loginName节点
		Element elementName = documrnt.createElement("loginName");
		
		//创建passWord节点
		Element elementPass = documrnt.createElement("password");
		
		elementName.setTextContent("admin");
		elementPass.setTextContent("123456");
		
		//将节点elementName和elementPass追加至element下
		element.appendChild(elementName);
		element.appendChild(elementPass);
		
		
		
		
		
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
}
