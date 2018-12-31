package com.yingxs.shunfengkuaidi;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.yingxs.shunfengkuaidi.bean.Address;

@WebService
public interface AddressInfoI {
	//	根据用户账号获取快递信息
	String getAdressInfoByUserId(String userId);
	
	//	获取所有网点信息
	List<Address> getAllAddress();
	
	Map<String,Address> getAllArea();
}
