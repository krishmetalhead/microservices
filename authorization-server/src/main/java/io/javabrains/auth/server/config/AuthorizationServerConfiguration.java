package io.javabrains.auth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;

@Configuration
public class AuthorizationServerConfiguration implements AuthorizationServerConfigurer {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	/*
	 * @Bean TokenStore jdbcTokenStore() { return new
	 * JdbcTokenStore(dataSource); }
	 */

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("isAuthenticated()").tokenKeyAccess("permitAll()");

	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("ClientId").secret("secret").authorizedGrantTypes("authorization_code")
				.scopes("user_info").autoApprove(true);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// endpoints.tokenStore(jdbcTokenStore());
		endpoints.authenticationManager(authenticationManager);
	}
}
