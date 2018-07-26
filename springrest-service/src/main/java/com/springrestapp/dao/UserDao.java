package com.springrestapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springrestapp.pojo.User;

public interface UserDao extends CrudRepository<User, Integer> {
@Query(value="select id,name,sal from user_info where id=?1",nativeQuery=true)
User getUser(int userid);

 
}
