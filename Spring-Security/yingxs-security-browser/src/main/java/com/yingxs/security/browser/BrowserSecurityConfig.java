package com.yingxs.security.browser;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import com.yingxs.security.core.authentication.mobile.AbstractChannelSecurityConfig;
import com.yingxs.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.yingxs.security.core.properties.SecurityConstants;
import com.yingxs.security.core.properties.SecurityProperties;
import com.yingxs.security.core.validate.code.ValidateCodeSecurityConfig;

@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig{

	@Autowired
	private SecurityProperties securityProperties;
	
	 
	@Autowired
	DataSource dataSource;
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	 
	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
	
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	
	@Autowired
	private SpringSocialConfigurer yingxsSocialConfigurer;
	
	
	@Autowired(required = false)
	private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;
	
	@Autowired(required = false)
	private InvalidSessionStrategy invalidSessionStrategy;
	
	
	
	// 配置密码加密与解密方式
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	
	// 配置TokenRepository
	@Bean
	public PersistentTokenRepository persistentTokenRepository () {
		
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		// 自动创建token存储的表
//		tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
		
	}
	
	
	 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		

		// 引用表单密码登录的相关配置
		applyPasswordAuthenticationConfig(http);
		
		http.apply(validateCodeSecurityConfig)
				.and()
			.apply(smsCodeAuthenticationSecurityConfig)
				.and()
			.apply(yingxsSocialConfigurer)     // 配置值引入社交账号登录的过滤器    默认处理/auth
				.and()
			.rememberMe()
				.tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
				.userDetailsService(userDetailsService)
			.and()
				.sessionManagement()
				.invalidSessionStrategy(invalidSessionStrategy) // session过期的处理
				.maximumSessions(securityProperties.getBrowser().getSession().getMaximumSession()) // 单用户最大session数量
				.maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionPreventsLogin()) // 当达到最大session数之后，禁止登录
				.expiredSessionStrategy(sessionInformationExpiredStrategy) // 干掉第一次登录的实现类，后面session踢掉前面的session
				.and()
				.and()
			.authorizeRequests()
				.antMatchers(
						SecurityConstants.DEFAULT_UNAUTHENTICATION_URL, 
						SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
						securityProperties.getBrowser().getLoginPage(),
						SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
						securityProperties.getBrowser().getSignUpUrl(),
						securityProperties.getBrowser().getSession().getSessionInvalidUrl(),
						"/user/regist")
						.permitAll()
				.anyRequest()
				.authenticated()
				.and()
			.csrf().disable();
		
		
		
		
		
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		
////		ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
////		validateCodeFilter.setAuthenticationFailureHandler(yingxsAuthenticationFaiurelHandler);
////		validateCodeFilter.setSecurityProperties(securityProperties);
////		validateCodeFilter.afterPropertiesSet();
//		// 在UsernamePasswordAuthenticationFilter过滤器之前加入自定义验证码过滤器
//		http 
//		.formLogin()
//		// 登录页面Url
//		.loginPage("/authentication/require")
//		// 登录页面请求地址
//		.loginProcessingUrl("/authentication/form")
//		// 配置登录成功后的处理器
//		.and()
//		.authorizeRequests()
//		// 排除该请求  不需要身份认证
//		.antMatchers("/authentication/require",
//				// 登录页面也不需要权限认证
//				securityProperties.getBrowser().getLoginPage(),
//				// 获取验证码不需要权限认证
//				"/code/image").permitAll()
//		.anyRequest()
//		.authenticated()
//		// 关闭csrf请求伪造防护
//		.and().csrf().disable();
//	}

	
	
}
