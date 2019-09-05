package com.yingxs.security.app.social.openId;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

import com.yingxs.security.core.authentication.mobile.SmsCodeAuthenticationToken;
import com.yingxs.security.core.properties.SecurityConstants;

public class OpenIdAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	
	private String openIdParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_OPENID;
	private String providerIdParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_PROVIDERID;
	
	private boolean postOnly = true;
	public OpenIdAuthenticationFilter() {
		super(new AntPathRequestMatcher(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_OPENID,"POST"));
	}
	
 
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		if (postOnly && !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		
		String openId = obtainOpenId(request);
		String providerId = obtainProviderId(request);
		
		if (openId == null) {
			openId = "";
		}
		
		if (providerId == null) {
			providerId = "";
		}
		
		openId = openId.trim();
		
		
		OpenIdAuthenticationToken authRequest = new OpenIdAuthenticationToken(openId, providerId);
		setDetails(request,authRequest);
		
		
		// TODO Auto-generated method stub
		return this.getAuthenticationManager().authenticate(authRequest);
	}
	
	protected String obtainOpenId(HttpServletRequest request) {
		return request.getParameter(openIdParameter);
	}
	protected String obtainProviderId(HttpServletRequest request) {
		return request.getParameter(providerIdParameter);
	}
	
	/**
	 * 请求信息设置到认证请求中
	 */
	protected void setDetails(HttpServletRequest request, OpenIdAuthenticationToken authRequest) {
		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
	}



	public String getOpenIdParameter() {
		return openIdParameter;
	}



	public void setOpenIdParameter(String openIdParameter) {
		this.openIdParameter = openIdParameter;
	}



	public String getProviderIdParameter() {
		return providerIdParameter;
	}



	public void setProviderIdParameter(String providerIdParameter) {
		this.providerIdParameter = providerIdParameter;
	}



	public boolean isPostOnly() {
		return postOnly;
	}



	public void setPostOnly(boolean postOnly) {
		this.postOnly = postOnly;
	}
	
	 
	


}
