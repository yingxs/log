package com.yingxs.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 方式三：动态方法访问方式
 * @author admin
 *
 */
public class Demo3Action extends ActionSupport {
	
	
	public String save() {
		System.out.println("Demo3Action的save()方法");
		return SUCCESS;
	}
	public String delete() {
		System.out.println("Demo3Action的update()方法");
		return SUCCESS;
	}
	

}
