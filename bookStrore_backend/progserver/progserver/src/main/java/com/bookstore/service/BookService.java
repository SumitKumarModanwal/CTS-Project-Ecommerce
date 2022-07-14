package com.bookstore.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;



public interface BookService {
//	ResponseEntity<?> getInventory();
//
//	ResponseEntity<?> addBookToInventory(Book book);
//
//	ResponseEntity<?> updateBookInInventory(Long bookId, Book book);
//	
//	ResponseEntity<?> removeBookFromInventory(Long bookId);
	
	public Book addBook(Book book);
	public Book updateBook(Book book);
	public Set<Book> getBooks();
	public void deleteBook(Long bookId);
	public Book getBook(Long bookId);
	public List<Book> getBooksOfCategory(Category category);
}
