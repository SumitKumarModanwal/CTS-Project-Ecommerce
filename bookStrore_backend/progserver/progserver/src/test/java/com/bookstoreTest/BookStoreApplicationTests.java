package com.bookstoreTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.BookStoreApplication;
import com.bookstore.controller.BookController;
import com.bookstore.controller.UserController;
import com.bookstore.entity.User;

import junit.framework.Assert;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=BookStoreApplication.class)
class BookStoreApplicationTests {
	
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private BookController bookController;
	
	@Test
	void testGetUsers() {
		Long bookId = null;
		Assert.assertNotNull(bookController.getBook( bookId));
	}
	
	@Test
	void testGetAllUsers() {
		Assert.assertNotNull(bookController.getBooks());;
	}
}