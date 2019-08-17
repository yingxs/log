package com.yingxs.code;

import org.springframework.web.context.request.ServletWebRequest;

import com.yingxs.security.core.validate.code.ValidateCodeGenerator;
import com.yingxs.security.core.validate.code.image.ImageCode;

//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

	@Override
	public ImageCode generate(ServletWebRequest request) {
		
		System.out.println("高级的图形验证码生成代码");
		
		return null;
	}

}
