package com.bookstore.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Role;
import com.bookstore.entity.User;
import com.bookstore.entity.UserRole;
import com.bookstore.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins ="http://localhost:4200",allowedHeaders ="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
		
		@Autowired
		private UserService userService;
		
		@Autowired
		private BCryptPasswordEncoder bCryptPasswordEncoder;
	
		@PostMapping("/")
		public User createUser(@RequestBody User user) throws Exception {
			
			user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
			Set<UserRole> roles = new HashSet<>();
			Role role = new Role();
			role.setRoleId(54L);
			role.setRoleName("NORMAL");
			
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);
			
			roles.add(userRole);
			
			
			
			return this.userService.createUser(user, roles);
		}
		
		@GetMapping("/{userName}")
		public User getUser(@PathVariable("userName") String userName) {
			System.out.println("User Should be here");
			return this.userService.getUser(userName);
		}
		
		@DeleteMapping("/{id}")
		public void deleteUser(@PathVariable("id") Long id) {
			
			this.userService.deleteUser(id);
		}
		
		@PutMapping("/edit")
		public User updateUser(@RequestBody User user) {
			return this.userService.updateUser(user.getId(), user);
		}
}
