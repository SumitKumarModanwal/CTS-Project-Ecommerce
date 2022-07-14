package com.bookstore.service;

import java.util.Set;

import com.bookstore.entity.User;
import com.bookstore.entity.UserRole;

public interface UserService {
	//Creating User
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	//Get User 
	public User getUser(String userName);
	//Delete by userName
	public void deleteUser(Long id);
	//Update User
	public User updateUser(Long id,User user);
}

