package com.yingxs.security.core.properties;

public class BrowserProperties {
	
	// 默认登录页面
	private String loginPage = "/yingxs-signIn.html";
	
	// 登录方式，跳转或返回JSON
	private LoginType loginType = LoginType.JSON;
	
	
	private int rememberMeSeconds = 3600 ;
	
	
	

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
	
	
	
	
	

}
