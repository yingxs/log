package com.yingxs.security.app.calidate.code.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.yingxs.security.core.validate.code.ValidateCode;
import com.yingxs.security.core.validate.code.ValidateCodeException;
import com.yingxs.security.core.validate.code.ValidateCodeRepository;
import com.yingxs.security.core.validate.code.ValidateCodeType;

@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;
	
	
	
	@PostConstruct
	public void  init() {
        RedisSerializer<?> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(stringSerializer);
//        redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer());
//        redisTemplate.setHashValueSerializer(fastJson2JsonRedisSerializer());
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
    }
	
	@Override
	public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType codeType) {
		// TODO Auto-generated method stub
		redisTemplate.opsForValue().set(buildKey(request,codeType), code,30,TimeUnit.MINUTES);
	}
	

	


	@Override
	public ValidateCode get(ServletWebRequest request, ValidateCodeType codeType) {
		Object value = redisTemplate.opsForValue().get(buildKey(request,codeType));
		if (value == null) {
			return null;
		}
		return (ValidateCode) value;
	}

	@Override
	public void remove(ServletWebRequest request, ValidateCodeType codeType) {
		redisTemplate.delete(buildKey(request,codeType));
		
	}
	
	private String buildKey(ServletWebRequest request,ValidateCodeType codeType) {
		String deviceId =  request.getHeader("deviceId");
		if (StringUtils.isBlank(deviceId)) {
			throw new ValidateCodeException("请在请求头携带deviceId参数");
		}
		return "code:" + codeType.toString().toLowerCase()+":"+deviceId;
	}

	

}
