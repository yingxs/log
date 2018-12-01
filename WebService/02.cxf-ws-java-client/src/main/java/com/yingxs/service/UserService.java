package com.yingxs.service;

import java.util.List;

import javax.jws.WebService;

import com.yingxs.domain.User;
/**
 *	@WebService 把该类标注为WebService接口，可能被远程调用
 *	该注解需要在JDK1.6以上使用
 */
@WebService
public interface UserService {

	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public List<User> findAllUser();
	public User findById();
	
	
	
}
