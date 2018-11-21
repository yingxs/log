package com.yingxs.it.shunFengKuaiDi;

import javax.jws.WebService;

@WebService
public interface AddressInfoI {
	//	根据用户账号获取快递信息
	String getAdressInfoByUserId(String userId);
}
