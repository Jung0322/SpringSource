package com.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.company.handler.CustomAccessDeniedHandler;
import com.company.handler.CustomLoginSuccessHandler;
import com.company.service.CustomUserDetailService;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	<!-- 암호화 객체 -->
//	<bean id="bCryptPasswordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"></bean>

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();		
	}
	
//	<!-- Custom service 객체 생성-->
//	<bean id="customUserDetailService" class="com.company.service.CustomUserDetailService"></bean>

	@Bean
	public UserDetailsService getuserdetailService() {
		return new CustomUserDetailService();
	}
	
//	<bean id="customAccessDeniedHandler" class="com.company.handler.CustomAccessDeniedHandler"></bean>

	@Bean
	public AccessDeniedHandler getAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
//	<bean id="customLoginSuccessHandler" class="com.company.handler.CustomLoginSuccessHandler"></bean>

	@Bean
	public AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	
	@Override	//<security:http>
	protected void configure(HttpSecurity http) throws Exception {
		
		// <security:access-denied-handler ~
		http.exceptionHandling(ex -> ex.accessDeniedHandler(getAccessDeniedHandler()));
		
		// <security: form-login~
		http.formLogin()
			.loginPage("/login")
			.failureUrl("/login-error")
			.successHandler(getAuthenticationSuccessHandler());
		
		// <security: logout
		http.logout()
			.logoutUrl("/logout")
			.invalidateHttpSession(true)
			.deleteCookies("rember-me","JSESSION_ID")
			.logoutSuccessUrl("/");
		
		//<security:intercept-url~
		http.authorizeRequests().antMatchers("/user-page").access("hasRole('ROLE_USER')")
								.antMatchers("/admin-page").access("hasRole('ROLE_ADMIN')")
								.antMatchers("/login").permitAll();
		
	}
}
