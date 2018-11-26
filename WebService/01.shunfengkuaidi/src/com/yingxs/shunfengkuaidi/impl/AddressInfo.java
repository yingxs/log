package com.yingxs.shunfengkuaidi.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.yingxs.shunfengkuaidi.AddressInfoI;
import com.yingxs.shunfengkuaidi.bean.Address;

@WebService(serviceName="sfkd",endpointInterface="com.yingxs.shunfengkuaidi.AddressInfoI")
public class AddressInfo implements AddressInfoI {

	@Override
	public String getAdressInfoByUserId(String userId) {
		// TODO Auto-generated method stub
		return "["+userId+"]:你的快递已经到达杭州萧山";
	}

	@Override
	public List<Address> getAllAddress() {
		List<Address> addresses = new ArrayList<>();
		Address address = new Address("广州潮汕","0001");
		Address address2 = new Address("浙江温州","0002");
		Address address3 = new Address("杭州萧山","0003");
		
		addresses.add(address);
		addresses.add(address2);
		addresses.add(address3);
		
		return addresses;
	}

	@Override
	public Map<String, Address> getAllArea() {
		
		HashMap<String, Address> addreses = new HashMap<String, Address>();
		Address address = new Address("广州潮汕","0001");
		Address address2 = new Address("浙江温州","0002");
		Address address3 = new Address("杭州萧山","0003");
		
		addreses.put("0001", address);
		addreses.put("0002", address2);
		addreses.put("0003", address3);
		
		return addreses;
	}

	
	
	
}
