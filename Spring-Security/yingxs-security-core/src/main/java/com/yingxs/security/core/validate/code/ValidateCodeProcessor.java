package com.yingxs.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码处理器，封装不同校验码的处理逻辑
 * @author yingxs
 *
 */
public interface ValidateCodeProcessor {
	
	/**
	 * 验证码放入session的前缀
	 */
	public static String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";
	
	void create(ServletWebRequest request) throws Exception;
	
	/**
	 * 校验验证码
	 * 
	 * @param servletWebRequest
	 * @throws Exception
	 */
	void validate(ServletWebRequest servletWebRequest);
	

}
