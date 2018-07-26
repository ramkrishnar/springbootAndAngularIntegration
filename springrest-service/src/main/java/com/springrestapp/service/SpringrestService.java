package com.springrestapp.service;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.springrestapp.pojo.User;

public interface SpringrestService {
	public String getProduct();
	public Iterable<User> getUserDetails();
	public User getUser(int id);
}
