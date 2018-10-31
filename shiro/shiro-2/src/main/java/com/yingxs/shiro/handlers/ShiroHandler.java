package com.yingxs.shiro.handlers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shiro")
public class ShiroHandler {

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		Subject currentUser = SecurityUtils.getSubject();
		// 判断用户是否认证(登录)
		if (!currentUser.isAuthenticated()) {
			// 把用户名和密码封装成UsernamePasswordToken对象
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			try {
				currentUser.login(token);
			} catch (AuthenticationException ae) {
				System.out.println();
				System.out.println("登陆失败： "+ae.getMessage());
				System.out.println();
//				ae.printStackTrace();
			}
		}
		return "redirect:/list.jsp";
	}

}
