package com.yingxs.security.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.social.security.SpringSocialConfigurer;

import com.yingxs.security.app.authentication.YingxsAuthenticationFaiurelHandler;
import com.yingxs.security.app.authentication.YingxsAuthenticationSuccessHandler;
import com.yingxs.security.app.social.openId.OpenIdAuthenticationSecurityConfig;
import com.yingxs.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.yingxs.security.core.properties.SecurityConstants;
import com.yingxs.security.core.properties.SecurityProperties;
import com.yingxs.security.core.validate.code.ValidateCodeSecurityConfig;

@Configuration
@EnableResourceServer
public class YingxsResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
	
	@Autowired
	private YingxsAuthenticationSuccessHandler yingxsAuthenticationSuccessHandler;
	@Autowired
	private YingxsAuthenticationFaiurelHandler yingxsAuthenticationFailureHandler;
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	
	@Autowired
	private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;
	
	@Autowired
	private SpringSocialConfigurer yingxsSocialConfigurer;

	 @Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
			.successHandler(yingxsAuthenticationSuccessHandler)
			.failureHandler(yingxsAuthenticationFailureHandler);
			
			http .apply(validateCodeSecurityConfig)
				 .and()
				.apply(smsCodeAuthenticationSecurityConfig)
					.and()
				.apply(yingxsSocialConfigurer)     // 配置值引入社交账号登录的过滤器    默认处理/auth
					.and()
				.apply(openIdAuthenticationSecurityConfig)
					.and()
				.authorizeRequests()
					.antMatchers(
							SecurityConstants.DEFAULT_UNAUTHENTICATION_URL, 
							SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
							securityProperties.getBrowser().getLoginPage(),
							SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
							securityProperties.getBrowser().getSignUpUrl(),
							securityProperties.getBrowser().getSession().getSessionInvalidUrl(),
							securityProperties.getBrowser().getSignOutUrl(),
							"/user/regist")
							.permitAll()
					.anyRequest()
					.authenticated()
					.and()
				.csrf().disable();
			
			
			
	}
	
	
}
