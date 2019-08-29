package com.yingxs.security.core.properties;

public class BrowserProperties {
	
	// 默认登录页面
	private String loginPage = "/yingxs-signIn.html";
	// 默认登录页面
	private String signUpUrl = "/yingxs-signUp.html";
	
	//登录失败跳转的url	
	private String signOutUrl ;
		
	// 登录方式，跳转或返回JSON
	private LoginType loginType = LoginType.JSON;
	
	
	
	
	
	private int rememberMeSeconds = 3600 ;
	
	private SessionProperties session = new SessionProperties();
	

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

	public String getSignUpUrl() {
		return signUpUrl;
	}

	public void setSignUpUrl(String signUpUrl) {
		this.signUpUrl = signUpUrl;
	}

	public SessionProperties getSession() {
		return session;
	}

	public void setSession(SessionProperties session) {
		this.session = session;
	}

	public String getSignOutUrl() {
		return signOutUrl;
	}

	public void setSignOutUrl(String signOutUrl) {
		this.signOutUrl = signOutUrl;
	}
	
	
	
	
	
	

}
