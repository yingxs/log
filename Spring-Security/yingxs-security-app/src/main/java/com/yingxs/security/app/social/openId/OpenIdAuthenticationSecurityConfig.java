package com.yingxs.security.app.social.openId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.AbstractSecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;


@Component
public class OpenIdAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain,HttpSecurity> {

	
	@Autowired
	private AuthenticationSuccessHandler yingxsAuthenticationSuccessHandler;
	
	@Autowired
	private AuthenticationFailureHandler yingxsAuthenticationFailureHandler;
	
	@Autowired
	private SocialUserDetailsService userDetailsService;
	
	@Autowired
	private UsersConnectionRepository usersConnectionRepository;
	
	
 @Override
public void configure(HttpSecurity http) throws Exception {
	// TODO Auto-generated method stub
	 OpenIdAuthenticationFilter openIdAuthenticationFilter = new OpenIdAuthenticationFilter();
	 openIdAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
	 openIdAuthenticationFilter.setAuthenticationSuccessHandler(yingxsAuthenticationSuccessHandler);
	 openIdAuthenticationFilter.setAuthenticationFailureHandler(yingxsAuthenticationFailureHandler);
	 
	 OpenIdAuthenticationProvider openIdAuthenticationProvider = new OpenIdAuthenticationProvider();
	 openIdAuthenticationProvider.setUserDetailsService(userDetailsService);
	 openIdAuthenticationProvider.setUsersConnectionRepository(usersConnectionRepository);
	 
	 http.authenticationProvider(openIdAuthenticationProvider)
	 .addFilterAfter(openIdAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
}
	
	
	
}
