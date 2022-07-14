package com.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUserName(String userName);
	
}
