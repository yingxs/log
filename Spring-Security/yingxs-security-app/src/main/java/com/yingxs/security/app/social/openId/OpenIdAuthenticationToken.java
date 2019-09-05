package com.yingxs.security.app.social.openId;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.security.SocialUserDetails;

public class OpenIdAuthenticationToken extends AbstractAuthenticationToken {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3356029177614612289L;
	
	
	private final Object principal;
	private String providerId;
	

	public OpenIdAuthenticationToken(String openId,String proivderId) {
		super(null);
		this.principal = openId;
		this.providerId = proivderId;
		setAuthenticated(false);
		// TODO Auto-generated constructor stub
	}

	public OpenIdAuthenticationToken(Object principal, 
			Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		super.setAuthenticated(true); // must use super, as we override
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}


	// 获取openId
	@Override
	public Object getPrincipal() {
		return principal;
	}


	public String getProviderId() {
		return providerId;
	}


	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

 
	

}
