package com.bookstore.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.User;
import com.bookstore.entity.UserRole;
import com.bookstore.repo.RoleRepository;
import com.bookstore.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//Creating User
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUserName(user.getUserName());
		if(local!=null) {
			System.out.println("User already exist!!");
			throw new Exception("User already there!!");
		}
		else {
			//create user
			for(UserRole urole:userRoles) {
				roleRepository.save(urole.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}
	
	
	//Getting User by userName
	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUserName(userName);
	}


	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
	}


	@Override
	public User updateUser(Long id, User user) {
		User editUser = this.userRepository.findById(id).get();
		
		editUser.setPassword(user.getPassword());
		editUser.setPhone(user.getPhone());
		
		return this.userRepository.save(user);
	}
	
}
