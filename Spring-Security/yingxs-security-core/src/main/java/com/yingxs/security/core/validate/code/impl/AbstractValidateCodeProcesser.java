package com.yingxs.security.core.validate.code.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.yingxs.security.core.validate.code.ValidateCode;
import com.yingxs.security.core.validate.code.ValidateCodeException;
import com.yingxs.security.core.validate.code.ValidateCodeGenerator;
import com.yingxs.security.core.validate.code.ValidateCodeProcessor;
import com.yingxs.security.core.validate.code.ValidateCodeRepository;
import com.yingxs.security.core.validate.code.ValidateCodeType;

public abstract class AbstractValidateCodeProcesser<C extends ValidateCode> implements ValidateCodeProcessor {

	
	/**
	 * 收集系统中所有的ValidateCodeGenerator接口实现
	 */
	@Autowired
	private Map<String,ValidateCodeGenerator> validateCodeGenerators;
	
	@Autowired
	private ValidateCodeRepository validateCodeRepository;
	
	@Override
	public void create(ServletWebRequest request) throws Exception {
		C validateCode = generate(request);
		save(request,validateCode);
		send(request,validateCode);
	}


	/**
	 * 发送验证码 由子类实现
	 * @param request
	 * @param validateCode
	 */
	protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;


	/**
	 * 保存验证码
	 * @param request
	 * @param validateCode
	 */
	protected  void save(ServletWebRequest request, C validateCode) {
		ValidateCode code = new ValidateCode(validateCode.getCode(),validateCode.getExpireTime());
//		sessionStrategy.setAttribute(request,  getSessionKey(request),code );
		validateCodeRepository.save(request, code, getValidateCodeType(request));
	};


	/**
	 * 生成验证码
	 * @param request
	 * @return
	 */
	protected   C generate(ServletWebRequest request) {
		
		String type = getValidateCodeType(request).toString().toLowerCase();
		String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
		ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
		if (validateCodeGenerator == null) {
			throw new ValidateCodeException("验证码生成器" + generatorName + "不存在");
		}
		return (C) validateCodeGenerator.generate(request);
		
		
	} 
	
 
	/**
	 * 构建验证码放入session时的key
	 * 
	 * @param request
	 * @return
	 */
	private String getSessionKey(ServletWebRequest request) {
		return SESSION_KEY_PREFIX + getValidateCodeType(request).toString().toUpperCase();
	}
	
	/**
	 * 根据请求的url获取校验码的类型
	 * 
	 * @param request
	 * @return
	 */
	private ValidateCodeType getValidateCodeType(ServletWebRequest request) {
		String type = StringUtils.substringBefore(getClass().getSimpleName(), "CodeProcessor");
		return ValidateCodeType.valueOf(type.toUpperCase());
	}
	 
	@SuppressWarnings("unchecked")
	@Override
	public void validate(ServletWebRequest request) {

		ValidateCodeType codeType = getValidateCodeType(request);
		String sessionKey = getSessionKey(request);

//		C codeInSession = (C) sessionStrategy.getAttribute(request, sessionKey);
		
		C codeInSession = (C) validateCodeRepository.get(request, codeType);

		String codeInRequest;
		try {
			codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),
					codeType.getParamNameOnValidate());
		} catch (ServletRequestBindingException e) {
			throw new ValidateCodeException("获取验证码的值失败");
		}

		if (StringUtils.isBlank(codeInRequest)) {
			throw new ValidateCodeException(codeType + "验证码的值不能为空");
		}

		if (codeInSession == null) {
			throw new ValidateCodeException(codeType + "验证码不存在");
		}

		if (codeInSession.isExpried()) {
//			sessionStrategy.removeAttribute(request, sessionKey);
			validateCodeRepository.remove(request, codeType);
			throw new ValidateCodeException(codeType + "验证码已过期");
		}

		if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
			throw new ValidateCodeException(codeType + "验证码不匹配");
		}

//		sessionStrategy.removeAttribute(request, sessionKey);
		validateCodeRepository.remove(request, codeType);
	}
	
	
	
	
	
	
	
	
}
