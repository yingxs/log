package com.yingxs.security.core.social.qq.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;

import com.yingxs.security.core.properties.QQProperties;
import com.yingxs.security.core.properties.SecurityProperties;
import com.yingxs.security.core.social.qq.connect.QQConnectionFactory;

/**
 * @author yingxs
 *
 */
@Configuration
@ConditionalOnProperty(prefix = "yingxs.security.social.qq",name="app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Autowired
	private DataSource dataSource;

	@Autowired(required = false)
	private ConnectionSignUp connectionSignUp;
	
	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		// TODO Auto-generated method stub
		
		QQProperties qqConfig = securityProperties.getSocial().getQq();
		
		return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
	}
	
	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		// TODO Auto-generated method stub
//		return super.getUsersConnectionRepository(connectionFactoryLocator);
		
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
		repository.setTablePrefix("yingxs_");
		
		if (connectionSignUp != null) {
			repository.setConnectionSignUp(connectionSignUp);
		}
		
		return repository;
	}
	
	
	

}
