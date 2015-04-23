package com.crab.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crab.service.AppSerivce;

@Controller
public class AppController
{
	private static final Logger logger = LogManager.getLogger(AppController.class);
	
	@Autowired
	AppSerivce appSerivce;

	@RequestMapping(value = { "/", "/helloworld**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage()
	{
		logger.info("====================== init ====================");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 3.2.3 Hello World Application");
		model.addObject("message", appSerivce.getName("Welcome Page !"));
		model.setViewName("helloworld");
		return model;

	}

	@RequestMapping(value = "/protected**", method = RequestMethod.GET)
	public ModelAndView protectedPage()
	{

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 3.2.3 Hello World");
		model.addObject("message", "This is protected page - Only for Administrators !");
		model.setViewName("protected");
		return model;

	}

	@RequestMapping(value = "/confidential**", method = RequestMethod.GET)
	public ModelAndView superAdminPage()
	{

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 3.2.3 Hello World");
		model.addObject("message", "This is confidential page - Need Super Admin Role !");
		model.setViewName("protected");

		return model;

	}

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 3.2.3 Hello World");
		model.addObject("message", "This is confidential page - Need Super Admin Role !");
		model.setViewName("protected");
		model.setViewName("background/login");
		return model;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index()
	{

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 4.0.0 Hello World");
		model.addObject("message", "This is confidential page - Need Super Admin Role !");
		model.setViewName("protected");

		return model;
	}
	
	@RequestMapping(value = "background/logout", method = RequestMethod.GET)
	public ModelAndView logout()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("background/logout");
		return model;
	}
}
