package com.yingxs.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;

public class ShiroRealm extends AuthenticatingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		//1...把AuthenticationToken转换为UsernamePasswordToken
		UsernamePasswordToken upToken  = (UsernamePasswordToken)token;
		//2.从UsernamePasswordToken中获取username
		String username = upToken.getUsername();
		//3.调用数据库的方法，从数据库中国查询usernae对应的用户记录
		System.out.println("从数据库中获取username:" + username +"所对应的用户信息");
		
		//4.若用户不存在，则可以抛出UnknownAccountException异常
		if("unknown".equals(username)) {
			throw new UnknownAccountException("用户不存在");
		}
		//5.根据用户信息的情况决定是否需要抛出其他的AuthenticationException异常
		if("monster".equals(username)) {
			throw new LockedAccountException("用户被锁定");
		}
		//6.根据用户的情况狂，来构建AuthenticationInfo，这是一个借口
		//通常使用的是实现类
		/**
		 1.principal 认证的实体信息，可以是username，也可以是数据表对应的用户实体类对象
		 2.credentials 密码
		 3.realmName 当前reamlm对象的name，调用父类的getName方法即可
		 */
		Object principal = username;
		Object credentials = "123456";
		String realmName=getName();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		
		
		return info;
	}

	

}
