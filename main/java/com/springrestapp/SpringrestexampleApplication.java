package com.springrestapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springrestapp.aop.CustomAop;
import com.springrestapp.aop.ServiceAop;
import com.springrestapp.service.SpringrestService;
import com.springrestapp.service.SpringrestServiceImpl;

@SpringBootApplication(scanBasePackages={
"com.springrestapp.serviceapi","com.springrestapp.service","com.springrestapp.dao.CustomerRepository"})
@EnableAutoConfiguration
@EnableAspectJAutoProxy()
public class SpringrestexampleApplication {
/*@Autowired
private SpringrestServiceImpl springrestServiceImpl;*/
	public static void main(String[] args) {
	SpringApplication.run(SpringrestexampleApplication.class, args);
	/*String confFile = "applicationcontext.xml";
        ConfigurableApplicationContext context 
                                = new ClassPathXmlApplicationContext(confFile);
        SpringrestServiceImpl busServ =   context.getBean("busServiceProxy",SpringrestServiceImpl.class);
        busServ.getUserDetails();*/
	}
	
	
	@Bean
	public ServiceAop serviceAop(){
		return new ServiceAop();
	}
	
	
}
