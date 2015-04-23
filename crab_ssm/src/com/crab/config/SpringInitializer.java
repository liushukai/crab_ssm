package com.crab.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	private static final Logger logger = LogManager.getLogger(SpringInitializer.class);
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		logger.info("================================================== init ");
		return new Class[] { ApplicationContext.class, ApplicationContext_webmvc.class ,SpringSecurity.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return null;
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[] { "/" };
	}

}
