package com.yingxs.domain;

public class User {

	private String userName;
	private String userPass;
	private String userTelephone;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPass=" + userPass + ", userTelephone=" + userTelephone + "]";
	}
	
	
	
}
