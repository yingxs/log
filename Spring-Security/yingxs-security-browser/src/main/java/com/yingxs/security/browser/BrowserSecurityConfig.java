package com.yingxs.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yingxs.security.core.properties.SecurityProperties;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;
	
	
	// 配置密码加密与解密方式
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
		// 登录页面Url
		.loginPage("/authentication/require")
		// 登录页面请求地址
		.loginProcessingUrl("/authentication/form")
//		http.httpBasic()
		.and()
		.authorizeRequests()
		// 排除该请求  不需要身份认证
		.antMatchers("/authentication/require",
				// 登录页面也不需要权限认证
				securityProperties.getBrowser().getLoginPage()).permitAll()
		.anyRequest()
		.authenticated()
		// 关闭csrf请求伪造防护
		.and().csrf().disable();
	}

	
	
}
