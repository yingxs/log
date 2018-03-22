package com.yingxs.action;
/**
 * Struts2的Action类
 * @author admin
 *
 */
public class HelloAction {
	
	public String hello(){
		System.out.println("进入Struts2的Action类");
		return "success";
	}

}
