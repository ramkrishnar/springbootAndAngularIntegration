package com.springrestapp.aop;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class CustomAop implements MethodBeforeAdvice{
	private static Logger logger = LogManager.getLogger(ServiceAop.class);
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		logger.info("before method execution");
	
	}

}

