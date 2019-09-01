package com.yingxs.security.browser;

import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.yingxs.security.core.validate.code.ValidateCode;
import com.yingxs.security.core.validate.code.ValidateCodeRepository;
import com.yingxs.security.core.validate.code.ValidateCodeType;

@Component
public class SessionValidateCodeRepository implements ValidateCodeRepository {

	
	/**
	 * 验证码放入session的前缀
	 */
	
	String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";
	
	
	/**
	 * 操作session的工具类
	 */
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	
	
	@Override
	public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType codeType) {
		sessionStrategy.setAttribute(request,  getSessionKey(request,codeType),code );

	}

	@Override
	public ValidateCode get(ServletWebRequest request, ValidateCodeType codeType) {
		return (ValidateCode) sessionStrategy.getAttribute(request, getSessionKey(request,codeType));
	}

	@Override
	public void remove(ServletWebRequest request, ValidateCodeType codeType) {
		sessionStrategy.removeAttribute(request, getSessionKey(request, codeType));
	}
	
	/**
	 * 构建验证码放入session时的key
	 * 
	 * @param request
	 * @return
	 */
	private String getSessionKey(ServletWebRequest request,ValidateCodeType codeType) {
		return SESSION_KEY_PREFIX + codeType.toString().toUpperCase();
	}

}
