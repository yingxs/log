package com.yingxs.tianmao;

import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import com.yingxs.shunfengkuaidi.Address;
import com.yingxs.shunfengkuaidi.AddressInfoI;
import com.yingxs.shunfengkuaidi.GetAllAreaResponse.Return;
import com.yingxs.shunfengkuaidi.GetAllAreaResponse.Return.Entry;
import com.yingxs.shunfengkuaidi.impl.Sfkd;

public class RunMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//1.获取服务端暴露的接口实例
		
		Sfkd sfkd = new Sfkd();
		
		//2.调用方法获取服务端web services远程代理实例
		AddressInfoI addressInfoPort = sfkd.getAddressInfoPort();
		
		//获取Client实例
		Client client = ClientProxy.getClient(addressInfoPort);

		//通过client添加日志拦截器
		client.getInInterceptors().add(new LoggingInInterceptor());//日志输出拦截器
		client.getOutInterceptors().add(new LoggingOutInterceptor());;//日志输入拦截器
		
		
		
		String info = addressInfoPort.getAdressInfoByUserId("张三");
		System.out.println(info);
		
		
		//2.获取所有网点信息
//		List<Address> Addresses = addressInfoPort.getAllAddress();
//		for (Address address : Addresses) {
//			System.out.println(address);;
//		}
		/* 
		Return maps = addressInfoPort.getAllArea();
		List<Entry> entrys = maps.getEntry();
		for (Entry entry : entrys) {
			System.out.println(entry.getKey()+":"+entry.getValue());
			
		}
		*/
		
		
		
	}

}
