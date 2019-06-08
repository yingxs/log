package com.yingxs.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {

	 private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		logger.info("登录用户名："+username);
		// 根据用户名查找用户信息
		// 根据查找到的用户信息判断用户是否被冻结
		
		return new User(username,"123456",
				true,// 可用
				true,// 账户未过期
				true,// 密码未过期
				false,// 未被锁定
				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}
