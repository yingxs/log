package com.yingxs.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 方式二：通配符访问方式
 * @author admin
 *
 */
public class Demo2Action extends ActionSupport {
	
	
	public String save() {
		System.out.println("Demo1Action的save()方法");
		return SUCCESS;
	}
	public String delete() {
		System.out.println("Demo1Action的update()方法");
		return SUCCESS;
	}
	

}
