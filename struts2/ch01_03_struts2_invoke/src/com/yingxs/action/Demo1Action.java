package com.yingxs.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 方式一：传统访问方式
 * @author admin
 *
 */
public class Demo1Action extends ActionSupport {
	
	
	public String save() {
		System.out.println("Demo1Action的save()方法");
		return SUCCESS;
	}
	public String update() {
		System.out.println("Demo1Action的update()方法");
		return SUCCESS;
	}
	

}
