package com.yingxs.action;

import com.opensymphony.xwork2.Action;

/**
 * Action的第二种写法：实现Action接口
 * 好处:
 * 		1.提供默认的excute方法，让Action类更加规范
 * 		2.提供了5个开发中常用的视图变量
 * 	
 * @author admin
 *
 */
public class Demo2Action implements Action {
	
	@Override
	public String execute() throws Exception {
		System.out.println("Action的第二种写法：实现Action接口");
		return SUCCESS;
	}

	
	
}
