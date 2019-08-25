package com.yingxs.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

public class YingxsSpringSocialConfigurer extends SpringSocialConfigurer {

	private String filterProcessesUrl ;
	
	public YingxsSpringSocialConfigurer(String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}



	@Override
	protected <T> T postProcess(T object) {
		
		SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
		filter.setFilterProcessesUrl(filterProcessesUrl);
		return (T) filter;
	}
	
	

}
