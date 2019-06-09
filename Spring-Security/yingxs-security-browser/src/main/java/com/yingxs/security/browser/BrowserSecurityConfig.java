package com.yingxs.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.yingxs.security.browser.authentication.YingxsAuthenticationSuccessHandler;
import com.yingxs.security.core.properties.SecurityProperties;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;
	
	
	// 登录成功的处理器
	@Autowired
	private AuthenticationSuccessHandler yingxsAuthenticationSuccessHandler;
	
	// 登录失败的处理器
	@Autowired
	private AuthenticationFailureHandler yingxsAuthenticationFaiurelHandler;
	
	
	
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
		// 配置登录成功后的处理器
		.successHandler(yingxsAuthenticationSuccessHandler)
		// 配置登录失败后的处理器
		.failureHandler(yingxsAuthenticationFaiurelHandler)
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
