package com.springrestapp.aop;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


//import com.springrestapp.service.SpringrestService;


@Component
@Aspect
public class ServiceAop {

	
	
	private static Logger logger = LogManager.getLogger(ServiceAop.class);

@Before(value="execution(* com.springrestapp.service.*.*(..))")
public void getusers(JoinPoint joinpoint){
		logger.info("before getuser method execution");
		
		logger.info("before getuser method execution");
		
	}
@After(value="execution(* com.springrestapp.service.SpringrestService.*(..)) and args(id)")
public void afterAdvice(JoinPoint joinpoint,int id){
		logger.info("after executing");
		logger.info(joinpoint.getSignature().getName());
		logger.info("value is");
		logger.info(joinpoint.getSignature().getName()+id); 
		
		
	}
	
	
	
	
}
