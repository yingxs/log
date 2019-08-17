package com.yingxs.security.core.validate.code.image;


import javax.imageio.ImageIO;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import com.yingxs.security.core.validate.code.impl.AbstractValidateCodeProcesser;

/**
 * 图形验证码处理器
 * @author yingxs
 *
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcesser<ImageCode> {

	@Override
	protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
		ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
		
	}

	 

	 

	 
}
