package com.yingxs.it.shunFengKuaiDi.impl;

import javax.jws.WebService;

import com.yingxs.it.shunFengKuaiDi.AddressInfoI;

@WebService(serviceName="sfkd",endpointInterface="com.yingxs.it.shunFengKuaiDi.AddressInfoI")
public class AddressInfo implements AddressInfoI {

	/**
	 *  根据用户账号获取快递信息
	 */
	@Override
	public String getAdressInfoByUserId(String userId) {
		// TODO Auto-generated method stub
		return "["+userId+"]:你的快递已经到达杭州萧山";
	}

}
