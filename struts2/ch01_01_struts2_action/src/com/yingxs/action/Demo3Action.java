package com.yingxs.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action的第三种写法：继承ActionSupport类
 * 好处:
 * 		1.有了Action接口的所有好处
 * 		2.还拥有其他功能接口
 * 	
 * @author admin
 *
 */
public class Demo3Action extends ActionSupport {
	
	@Override
	public String execute() throws Exception {

		System.out.println("Action的第三种写法：继承ActionSupport类");
		return SUCCESS;
	}
	
	
}
