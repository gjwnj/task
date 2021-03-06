package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFactory {
	public static Logger getBusinessLogger()
	{
		return LoggerFactory.getLogger(LogEnum.BUSINESS.getCategory());
	}
	public static Logger getPlatformLogger()
	{
		return LoggerFactory.getLogger(LogEnum.PLATFORM.getCategory());
	}
	public static Logger getDBLogger()
	{
		return LoggerFactory.getLogger(LogEnum.DB.getCategory());
	}
	public static Logger getException()
	{
		return LoggerFactory.getLogger(LogEnum.EXCEPTION.getCategory());
	}

}
