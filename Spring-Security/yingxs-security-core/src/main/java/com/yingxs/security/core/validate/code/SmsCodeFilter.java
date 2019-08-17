package com.yingxs.security.core.validate.code;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import com.yingxs.security.core.properties.SecurityProperties;
/*
public class ValidateCodeFilter extends OncePerRequestFilter  {

	private AuthenticationFailureHandler authenticationFailureHandler;
	
	
	private  SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	
	private Set<String> urls = new HashSet<String>();
	
	private SecurityProperties securityProperties;
	
	private AntPathMatcher pathMather = new AntPathMatcher();
	
	
	
	@Override
	public void afterPropertiesSet() throws ServletException {
		// TODO Auto-generated method stub
		super.afterPropertiesSet();
		String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getImage().getUrl(), ",");
		for (String configUrl : configUrls) {
			urls.add(configUrl);
		}
		urls.add("/authentication/form");
		
	}
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		boolean action = false;
		for (String url : urls) {
			if (pathMather.match(url, request.getRequestURI())) {
				action = true;
			}
		}
		
		if (action) {
			try {
				validate(new ServletWebRequest(request));
			} catch (ValidateCodeExcecption e) {
				authenticationFailureHandler.onAuthenticationFailure(request, response, e);
				return ;
			}
		}
		filterChain.doFilter(request, response);
	}

	private void validate(ServletWebRequest request) throws ServletRequestBindingException {
		ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request, ValidateCodeController.SESSION_KEY);
		
		String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
		
		if (StringUtils.isBlank(codeInRequest)) {
			throw new ValidateCodeExcecption("验证码的值不能为空");
		}
		if (codeInSession == null) {
			throw new ValidateCodeExcecption("验证码不存在");
		}
		
		if (codeInSession.isExpried()) {
			sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
			throw new ValidateCodeExcecption("验证码已过期");
		}
		
		if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
			throw new ValidateCodeExcecption("验证码不匹配");
		}
		
		
		sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
		
		
		
	}

	public AuthenticationFailureHandler getAuthenticationFailureHandler() {
		return authenticationFailureHandler;
	}

	public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
		this.authenticationFailureHandler = authenticationFailureHandler;
	}

	public SessionStrategy getSessionStrategy() {
		return sessionStrategy;
	}

	public void setSessionStrategy(SessionStrategy sessionStrategy) {
		this.sessionStrategy = sessionStrategy;
	}



	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}



	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
	
	
	
	
	

}*/
import com.yingxs.security.core.validate.code.image.ImageCode;


public class SmsCodeFilter extends OncePerRequestFilter implements InitializingBean {

	// 认证失败处理器
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	// 操作session工具类
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	
	
	private Set<String> urls = new HashSet<>();
	
	private SecurityProperties securityProperties;
	
	private AntPathMatcher pathMatcher = new AntPathMatcher();
		
	
	
	
	@Override
	public void afterPropertiesSet() throws ServletException {
		super.afterPropertiesSet();
		String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getSms().getUrl(), ",");
		for (String configUrl : configUrls) {
			urls.add(configUrl);
		}
		urls.add("/authentication/mobile");
		
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		boolean action = false;
		for (String url : urls) {
			if (pathMatcher.match(url, request.getRequestURI())) {
				action = true;
			}
		}
		
		if(action) {
			
			try {
				validate(new ServletWebRequest(request));
			} catch (ValidateCodeException e) {
				authenticationFailureHandler.onAuthenticationFailure(request, response,e);
				return ;
			}
			
		}
		
		filterChain.doFilter(request, response);
		
		
		
		
		
	}

	private void validate(ServletWebRequest request) throws ServletRequestBindingException   {
		// 从session中取出之前的ValidateCode
		ValidateCode codeInSession = (ValidateCode) sessionStrategy.getAttribute(request, ValidateCodeProcessor.SESSION_KEY_PREFIX+"SMS");
		
		String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "smsCode");
		
		if (StringUtils.isBlank(codeInRequest)) {
			throw new ValidateCodeException("验证码的值不能为空");
		}
		if (codeInSession == null) {
			throw new ValidateCodeException("验证码不存在");
		}
		
		if (codeInSession.isExpried()) {
			sessionStrategy.removeAttribute(request, ValidateCodeProcessor.SESSION_KEY_PREFIX+"SMS");
			throw new ValidateCodeException("验证码已过期");
		}
		
		if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
			throw new ValidateCodeException("验证码不匹配");
		}
		
		// 验证码认证成功，将验证码从session中移除
		sessionStrategy.removeAttribute(request, ValidateCodeProcessor.SESSION_KEY_PREFIX+"SMS");
		
		
		
	}

	public AuthenticationFailureHandler getAuthenticationFailureHandler() {
		return authenticationFailureHandler;
	}

	public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
		this.authenticationFailureHandler = authenticationFailureHandler;
	}

	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
	
	
	
	
	
 

}
