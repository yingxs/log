package com.yingxs.shiro.handler;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yingxs.shiro.services.ShiroService;

@RequestMapping("/shiro")
@Controller
public class ShiroHandler {
	
	@Autowired
	private ShiroService shiroService;
	
	
	@RequestMapping("/testShiroAnnotation")
	public String testShiroAnnotation() {
		shiroService.testMethod();
		return "redirect:/list.jsp";
	}
	
	
	
	@RequestMapping("/login")
	public String login(String username,String password) {
		
		/*

			1. 获取当前的Subject,调用SecurityUtils.getSubject();
			
			2. 测试当前的用户是否已经被认证，，也就是说是否已经登录,调用Subject的isAuthentiated()
			3. 若没有被认证，则将用户名和密码封装为UsernamePasswordToken对象
			4. 执行登录：调用Subject的login(AuthenticationToken)方法
			    1. UsernamePasswordTokens是AuthenticationToken的实现类
			5. 自定义Realm方法，从数据表库中获取相应的记录，返回给shiro
			     1. 实际上需要继承org.apache.shiro.realm.AuthenticatingRealm类
			     2. 实现doGetAuthentication(AuthenticationToken)方法
			6. 由shiro进行密码比对
		 */
		
		
		Subject currentUser = SecurityUtils.getSubject();
		if  (!currentUser.isAuthenticated() ) {
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			token.setRememberMe(true);
			
			try {
				currentUser.login(token);
			} catch (AuthenticationException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		
		
		return "redirect:/list.jsp";
	}
	
}
