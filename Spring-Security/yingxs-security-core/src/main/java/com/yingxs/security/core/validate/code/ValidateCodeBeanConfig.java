package com.yingxs.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yingxs.security.core.properties.SecurityProperties;
import com.yingxs.security.core.validate.code.image.ImageCodeGenerator;
import com.yingxs.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.yingxs.security.core.validate.code.sms.SmsCodeSender;

@Configuration
public class ValidateCodeBeanConfig {

	@Autowired
	private SecurityProperties securityProperties;
	
	@Bean // 不存在名为imageCodeGenerator的bean时才用这个
	@ConditionalOnMissingBean( name = "imageValidateCodeGenerator")
	public ValidateCodeGenerator imageValidateCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
		
	}
	
	
	@Bean 
	@ConditionalOnMissingBean( SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
		
	}
	
	
}
