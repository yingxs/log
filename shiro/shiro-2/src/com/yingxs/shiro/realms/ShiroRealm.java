package com.yingxs.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;

public class ShiroRealm extends AuthenticatingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1.把AuthenticationToken转换为UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 2.从UsernamePasswordToken中获取username
		String username = upToken.getUsername();
		// 3.调用数据库的方法，从数据库中查询username对象的记录
		System.out.println("从数据库中获取username:"+username+"所对应的用户信息.");
		// 4.若用户不存在则可以抛出UnknownAccountException异常
		if ( "unknown".equals(username) ) {
			throw new UnknownAccountException("用户不存在");
		}
		// 5.根据用户信息的情况，决定是否需要抛出其他异常
		if ( "monster".equals(username) ) {
			throw new LockedAccountException("用户被锁定");
		}
		
		// 6.根据用户情况构建AuthenticationInfo对象并返回；通常使用的实现类为SimpleAuthenticationInfo
		
		//1.principal 认证的实体信息可以是usernmae也可以是用户的实体类对象
		Object principal = username;
		//2.credentials 密码
		Object credentials = "fc1709d0a95a6be30bc5926fdb7f22f4";
		//3.realmName 当前realm对象的name 调用父类的getName()即可
		String realmName = getName();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);

		
		return info;
	}
	
	public static void main(String[] args) {
		String hashAlgoritthmName="MD5";
		Object credentials="123456";
		Object salt = null;
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgoritthmName, credentials, salt, hashIterations);
		System.out.println(result);
		
	}


	
}
