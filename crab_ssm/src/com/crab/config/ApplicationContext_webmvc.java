package com.crab.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.crab.interceptor.SpringMvcInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.crab.controller", useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class }) })
public class ApplicationContext_webmvc extends WebMvcConfigurationSupport
{
	private static final Logger logger = LogManager.getLogger(SpringInitializer.class);

	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public HandlerMapping resourceHandlerMapping()
	{
		return super.resourceHandlerMapping();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver commonsMultipartResolver()
	{
		return new CommonsMultipartResolver();
	}

	@Bean
	public MessageSource messageSource()
	{
		logger.info("MessageSource");
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("config.messages.messages");

		return messageSource;
	}

	/**
	 * 必须显示声明否则无法添加自定义拦截器
	 * ====================================================================
	 */
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping()
	{
		logger.info("RequestMappingHandlerMapping");
		return super.requestMappingHandlerMapping();
	}

	@Bean
	public SpringMvcInterceptor initializingInterceptor()
	{
		logger.info("SpringMvcInterceptor");
		return new SpringMvcInterceptor();
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry)
	{
		logger.info("addInterceptors start");
		registry.addInterceptor(initializingInterceptor());
		registry.addWebRequestInterceptor(initializingInterceptor());
		logger.info("addInterceptors end");
	}
	// ========================================================================
}
