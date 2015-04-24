package com.crab.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.event.LoggerListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter
{

	private static final Logger logger = LogManager.getLogger(SpringSecurity.class);

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		// 设置不拦截规则
		web.ignoring().antMatchers("/js/**", "/**/*.jsp");

	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		/** 配置
		 * 	<http>
		 *		<intercept-url pattern="/**" access="authenticated"/>
		 *		<form-login />
		 *		<http-basic />
		 *	</http>
		 *	http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().httpBasic();
		 */
		//http.formLogin().defaultSuccessUrl("", true);
		http.authorizeRequests()                                                                
			.antMatchers("/background/**").hasRole("ADMIN")                                
			//.anyRequest().authenticated()               
			.and().formLogin().loginPage("/login").permitAll();
		// 设置拦截规则
		// 自定义accessDecisionManager访问控制器,并开启表达式语言
		// http.authorizeRequests().accessDecisionManager(accessDecisionManager()).expressionHandler(webSecurityExpressionHandler()).antMatchers("/**/*.do*")
		// .hasRole("USER").antMatchers("/**/*.htm").hasRole("ADMIN").and().exceptionHandling().accessDeniedPage("/login");
		// // 开启默认登录页面
		// // http.formLogin();
		// // 自定义登录页面
		// http.csrf().disable().formLogin().loginPage("/login").failureUrl("/login?error=1").loginProcessingUrl("/j_spring_security_check")
		// .usernameParameter("j_username").passwordParameter("j_password").permitAll();
		// // 自定义注销
		// http.logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true);
		// // session管理
		// http.sessionManagement().sessionFixation().changeSessionId().maximumSessions(1).expiredUrl("/");
		// // RemeberMe
		// http.rememberMe().key("webmvc#FD637E6D9C0F1A5A67082AF56CE32485");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("liusk").password("liusk").roles("ADMIN");
		// auth.inMemoryAuthentication().
		// 自定义UserDetailsService
		// auth.userDetailsService(userDetailsService()).passwordEncoder(new
		// Md5PasswordEncoder());

	}

	@Bean
	public LoggerListener loggerListener()
	{
		logger.info("org.springframework.security.authentication.event.LoggerListener");
		LoggerListener loggerListener = new LoggerListener();

		return loggerListener;
	}

	@Bean
	public org.springframework.security.access.event.LoggerListener eventLoggerListener()
	{
		logger.info("org.springframework.security.access.event.LoggerListener");
		org.springframework.security.access.event.LoggerListener eventLoggerListener = new org.springframework.security.access.event.LoggerListener();

		return eventLoggerListener;
	}

}
