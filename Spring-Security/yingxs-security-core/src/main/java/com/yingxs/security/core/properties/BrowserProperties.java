package com.yingxs.security.core.properties;

public class BrowserProperties {
	
	// 默认登录页面
	private String loginPage = "/yingxs-signIn.html";
	
	private LoginType loginType = LoginType.JSON;
	
	
	

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
	
	
	

}
