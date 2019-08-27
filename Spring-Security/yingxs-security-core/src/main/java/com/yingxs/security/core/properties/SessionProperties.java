package com.yingxs.security.core.properties;

public class SessionProperties {
	
	/**
	 * 	一个用户在系统中的最大session数量  默认1
	 */
	private int maximumSession = 1;
	
	/**
	 * 达到最大session时是否阻止新的登录请求，默认为false，不阻止，新的登录会将老的登录失效掉
	 */
	private boolean maxSessionPreventsLogin;
	
	/**
	 * session失效时跳转的地址
	 */
	private String sessionInvalidUrl = SecurityConstants.DEFAULT_SESSION_INVALID_URL;

	public int getMaximumSession() {
		return maximumSession;
	}

	public void setMaximumSession(int maximumSession) {
		this.maximumSession = maximumSession;
	}

	public boolean isMaxSessionPreventsLogin() {
		return maxSessionPreventsLogin;
	}

	public void setMaxSessionPreventsLogin(boolean maxSessionPreventsLogin) {
		this.maxSessionPreventsLogin = maxSessionPreventsLogin;
	}

	public String getSessionInvalidUrl() {
		return sessionInvalidUrl;
	}

	public void setSessionInvalidUrl(String sessionInvalidUrl) {
		this.sessionInvalidUrl = sessionInvalidUrl;
	}
	
	
	

}
