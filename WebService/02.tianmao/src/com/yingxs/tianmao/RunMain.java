package com.yingxs.tianmao;

import java.util.List;

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

		//String info = addressInfoPort.getAdressInfoByUserId("张三");
		//System.out.println(info);
		
		
		//2.获取所有网点信息
//		List<Address> Addresses = addressInfoPort.getAllAddress();
//		for (Address address : Addresses) {
//			System.out.println(address);;
//		}
		 
		Return maps = addressInfoPort.getAllArea();
		List<Entry> entrys = maps.getEntry();
		for (Entry entry : entrys) {
			System.out.println(entry.getKey()+":"+entry.getValue());
			
		}
		
		
		
		
	}

}
