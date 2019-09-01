package com.yingxs.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeRepository {
	
	
	/**
	 * 	保存验证码
	 * @param request
	 * @param code
	 * @param validateCode
	 */
	void save(ServletWebRequest request,ValidateCode code,ValidateCodeType codeType);
	
	/**
	 * 	获取验证码
	 * @param request
	 * @param validateCode
	 * @return
	 */
	ValidateCode get(ServletWebRequest request,ValidateCodeType codeType);
	

	/**
	 *  	移除验证码
	 * @param request
	 * @param validateCode
	 */
	void remove(ServletWebRequest request,ValidateCodeType codeType);
	
}
