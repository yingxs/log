package com.yingxs.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {

	private static final long serialVersionUID = 8409858098668931148L;

	public ValidateCodeException(String msg) {
		super(msg);
	}

}
