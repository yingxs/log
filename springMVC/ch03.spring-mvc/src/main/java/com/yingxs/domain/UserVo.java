package com.yingxs.domain;

public class UserVo {
	private User user;
	private String gender;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "UserVo [user=" + user + ", gender=" + gender + "]";
	}
	
	
	
}
