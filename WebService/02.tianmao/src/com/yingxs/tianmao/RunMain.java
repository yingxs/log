package com.yingxs.tianmao;

import com.yingxs.it.shunfengkuaidi.AddressInfoI;
import com.yingxs.it.shunfengkuaidi.impl.Sfkd;

public class RunMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//1.获取服务端暴露的接口实例
		
		Sfkd sfkd = new Sfkd();
		
		//2.调用方法获取服务端web services远程代理实例
		AddressInfoI addressInfoPort = sfkd.getAddressInfoPort();

		String info = addressInfoPort.getAdressInfoByUserId("张三");
		
		System.out.println(info);
		
	}

}
