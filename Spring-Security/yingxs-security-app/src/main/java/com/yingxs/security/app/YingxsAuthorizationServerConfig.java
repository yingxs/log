package com.yingxs.security.app;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.yingxs.security.core.properties.OAuth2ClientProperties;
import com.yingxs.security.core.properties.SecurityProperties;

@Configuration
@EnableAuthorizationServer
public class YingxsAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService 	userDetailsService;
	
	@Autowired
	private SecurityProperties securityProperties;
	
	
	@Autowired
	private TokenStore tokenStore;
	
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(tokenStore)
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService);
	}

	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		
		InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
		
		if (ArrayUtils.isNotEmpty(securityProperties.getOauth2().getClients())) {
			for (OAuth2ClientProperties client : securityProperties.getOauth2().getClients()) {
				builder.withClient(client.getClientId())
					.secret(client.getClientSecret())
					.accessTokenValiditySeconds(client.getAccessTokenValiditySeconds()) //令牌有效时间 单位秒
					.authorizedGrantTypes( "refresh_token","password")  // 支持的授权模式
					.scopes("all","read","write");
			}
		}
		
	}	
	
}
