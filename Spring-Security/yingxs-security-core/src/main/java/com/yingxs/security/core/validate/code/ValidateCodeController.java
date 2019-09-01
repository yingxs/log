package com.yingxs.security.core.validate.code;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yingxs.security.core.support.SimpleResponse;

@RestController
public class ValidateCodeController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private Map<String,ValidateCodeProcessor> validateCodeProcessor;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@GetMapping("/code/{type}")
	public void createCode(HttpServletRequest request,HttpServletResponse response,@PathVariable String type)  {
		try {
			validateCodeProcessor.get(type+"ValidateCodeProcessor").create(new ServletWebRequest(request, response));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
	 

}
