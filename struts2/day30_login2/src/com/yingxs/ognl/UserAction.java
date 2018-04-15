package com.yingxs.ognl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport {
	
	//用户在每次访问action对象的业务方法时，struts2框架会创建ActionContext对象 （OgnlValueStack对象）（Action对象））
	
	@Override
	public String execute() throws Exception {
		//1.获取ActionContext对象
		ActionContext ac = ActionContext.getContext();
		//2.从ActionContext对象获取OgnlValueStack对象
		ValueStack vs = ac.getValueStack();
		//3.查看OgnlValueStack对象的结构
		return super.execute();
	}
	
}
