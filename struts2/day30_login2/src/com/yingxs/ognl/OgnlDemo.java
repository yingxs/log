package com.yingxs.ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import org.junit.Test;

//目标：学习了解Ognl表达式的核心对象OgnlContext对象的使用
public class OgnlDemo {
	
	@Test
	public void test1(){
		User user = new User();
		user.setName("yingxs");
		user.setAge(20);
		
		//创建一个OgnlContext对象
		OgnlContext context = new OgnlContext();
		//把user对象存入OgnlContext对象
		context.put("user",user);
		//从OgnlContext对象中取出数据
		User user2 = (User)context.get("user");
		System.out.println(user2.getName()+"\t"+user2.getAge());
	}
	
	//使用Ognl表达式取出OgnlContext的数据，如果是非根对象的数据，那么必须使用#
	@Test
	public void test2() throws OgnlException{
		User user = new User();
		user.setName("yingxs");
		user.setAge(20);
		
		//创建一个OgnlContext对象
		OgnlContext context = new OgnlContext();
		//把user对象存入OgnlContext对象
		context.put("user",user);		//往OgnlContext的根对象存数据
		
		//使用ognl表达式从OgnlContext对象中取出数据
		Object ognlObj = Ognl.parseExpression("#user.name");			//表达式对象
		String name = (String)Ognl.getValue(ognlObj, context, context.getRoot());			//获取数据方法
		System.out.println(name);
	}
	
	//使用Ognl表达式取出OgnlContext的数据，如果是根对象的数据，那么不需要使用#，不需要key名称
	@Test
	public void test3() throws OgnlException{
		User user = new User();
		user.setName("yingxs");
		user.setAge(20);
		
		//创建一个OgnlContext对象
		OgnlContext context = new OgnlContext();
		//把user对象存入OgnlContext对象
		context.setRoot(user);		//往OgnlContext的根对象存数据
		
		//使用ognl表达式从OgnlContext对象中取出数据
		Object ognlObj = Ognl.parseExpression("age");			//表达式对象
		Object name = (Object)Ognl.getValue(ognlObj, context, context.getRoot());			//获取数据方法
		System.out.println(name);
	}
	
	//使用Ognl表达式调用静态方法
	@Test
	public void test4() throws OgnlException{
		//创建一个OgnlContext对象
		OgnlContext context = new OgnlContext();
		
		//使用ognl表达式从OgnlContext对象中取出数据
//		Object ognlObj = Ognl.parseExpression("@java.lang.Math@round(10.5)");			//表达式对象
		Object ognlObj = Ognl.parseExpression("@Math@round(10.5)");			//表达式对象
		Object name = (Object)Ognl.getValue(ognlObj, context, context.getRoot());			//获取数据方法
		System.out.println(name);

	}
	
}
