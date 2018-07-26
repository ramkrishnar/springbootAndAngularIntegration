package com.springrestapp.serviceapi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springrestapp.pojo.Address;
import com.springrestapp.pojo.User;

public interface ServiceApi {
	@RequestMapping(value="/")
	public String getProduct();
	@GetMapping(value="/alluser")
	public Iterable<User> gatAllUser();
	@GetMapping(value="/getuser/{id}", produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public User getUser(@PathVariable("id") int id);
	
	
	
	
	}
