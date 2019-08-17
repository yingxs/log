package com.yingxs.security.core.authentication.mobile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

/**
 * @author yingxs
 *
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	 
	public static final String YINGXS_FORM_MOILE_KEY = "mobile";

	// 请求中手机号的参数名
	private String mobileParameter = YINGXS_FORM_MOILE_KEY;
	
	// 当前过滤器只处理POST请求
	private boolean postOnly = true;

	 
	public SmsCodeAuthenticationFilter() {
		super(new AntPathRequestMatcher("/authentication/mobile", "POST"));
	}
	 
	/**
	 * 认证流程
	 */
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (postOnly && !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}

		String mobile = obtainMobile(request);

		if (mobile == null) {
			mobile = "";
		}

		 

		mobile = mobile.trim();

		SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(mobile);

		// 将请求信息设置到token中去
		setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}

	 
	/**
	 * 从请求中获取手机号
	 */
	protected String obtainMobile(HttpServletRequest request) {
		return request.getParameter(mobileParameter);
	}

	/**
	 * 请求信息设置到认证请求中
	 */
	protected void setDetails(HttpServletRequest request, SmsCodeAuthenticationToken authRequest) {
		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
	}
 
	public void setMobileParameter(String usernameParameter) {
		Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
		this.mobileParameter = usernameParameter;
	}
	
	public final String getMobileParameter() {
		return this.mobileParameter;
	}
	
	
 
	public void setPostOnly(boolean postOnly) {
		this.postOnly = postOnly;
	}

	

	 
}