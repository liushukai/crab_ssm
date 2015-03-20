package com.crab.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.crab.controller.AppController;

public class SpringMvcInterceptor extends HandlerInterceptorAdapter implements WebRequestInterceptor
{
	private static final Logger logger = LogManager.getLogger(AppController.class);

	@Override
	public void preHandle(WebRequest request) throws Exception
	{
		logger.info("preHandle");
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception
	{
		logger.info("postHandle");
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception
	{
		logger.info("afterCompletion");
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		logger.info("===================preHandle");
		return true;
	}

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		logger.info("===================postHandle" + modelAndView.getViewName());
	}

	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("===================afterCompletion");
	}

}
