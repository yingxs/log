package com.yingxs.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
/**
 * 验证码对象
 * @author admin
 *
 */
public class ValidateCode {
	
	
	private String code;
	
	private LocalDateTime expireTime;
	

	public ValidateCode( String code, int expireIn) {
		super();
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}
	public ValidateCode(  String code, LocalDateTime expireTime) {
		super();
		this.code = code;
		this.expireTime = expireTime;
	}

 

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}
	public boolean isExpried() {
		return LocalDateTime.now().isAfter(expireTime);
	}
	

}
