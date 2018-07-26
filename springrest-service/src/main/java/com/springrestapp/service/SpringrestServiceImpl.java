package com.springrestapp.service;






import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springrestapp.dao.UserDao;
import com.springrestapp.pojo.User;
//import com.springrestapp.serviceapi.ServiceApiImpl;






@Service
public class SpringrestServiceImpl implements SpringrestService{
	private static Logger logger = LogManager.getLogger(SpringrestServiceImpl.class);
	
	@Autowired
	private UserDao userdao;
	public String getProduct(){
		return "hello world";
	}
	public Iterable<User> getUserDetails(){
	logger.info("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		return  userdao.findAll();
		
	}
	
	public User getUser(int id){
		logger.info("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		return userdao.getUser(id);
		
	}
	
	
}
