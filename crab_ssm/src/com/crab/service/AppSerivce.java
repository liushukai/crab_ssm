package com.crab.service;

import org.springframework.stereotype.Service;

@Service
public class AppSerivce
{
	public String getName(String name)
	{
		return "=========" + name;
	}
}
