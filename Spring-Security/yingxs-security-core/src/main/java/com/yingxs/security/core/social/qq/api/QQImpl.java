package com.yingxs.security.core.social.qq.api;

import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author admin
 *
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

	private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
	private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
	
	private String appId;
	private String openId;
	
	private ObjectMapper objectMapper= new ObjectMapper();
	
	
	public QQImpl(String accessToken,String appId) {
		// TokenStrategy.ACCESS_TOKEN_PARAMETER token策略 将token作为参数传递
		super(accessToken,TokenStrategy.ACCESS_TOKEN_PARAMETER);
		this.appId = appId;
		
		// 获取openId
		String url = String.format(URL_GET_OPENID, accessToken);
		String result = getRestTemplate().getForObject(url, String.class);
		
		System.out.println("openIdResult:"+result);
		this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
		System.out.println("openId: "+openId);
	}
	
	
	
	
	@Override
	public QQUserInfo getUserInfo()  {
		try {
			String url = String.format(URL_GET_USERINFO, appId,openId);
			String result = getRestTemplate().getForObject(url, String.class);
			
			QQUserInfo userInfo = objectMapper.readValue(result, QQUserInfo.class);
			userInfo.setOpenId(openId);
			System.out.println("userInfo:"+result);
			return userInfo;
		} catch (Exception e) {
			throw new RuntimeException("获取用户信息失败",e);
		}
	}

}
