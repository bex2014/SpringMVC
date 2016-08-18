package com.bex.spring.MVC.configs.dop;

import com.bex.spring.MVC.configs.dop.OAuth2SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true, jsr250Enabled = true, mode = AdviceMode.PROXY)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
	@SuppressWarnings("unused")

	@Autowired
	private OAuth2SecurityConfiguration securityConfig;

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		return new OAuth2MethodSecurityExpressionHandler();
	}
}
