package com.bookstore.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.repo.BookRepository;



@Service
public class BookServiceImpl implements BookService {
	private static final Logger LOGGER = LoggerFactory.getLogger("BOOK SERVICE - ADMIN");
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Set<Book> getBooks() {
		return new HashSet<>(bookRepository.findAll());
	}

	@Override
	public void deleteBook(Long bookId) {
		
        this.bookRepository.deleteById(bookId);
	}

	@Override
	public Book getBook(Long bookId) {
		return this.bookRepository.findById(bookId).get();
	}

	@Override
	public List<Book> getBooksOfCategory(Category category) {

		return this.bookRepository.findByCategory(category);
	}

	
	
	

//	@Override
//	public ResponseEntity<?> addBookToInventory(Book book) {
//		LOGGER.warn(book.toString());
//		Book bookCreated = bookRepository.save(book);
//		LOGGER.warn(bookCreated.toString());
//		return new ResponseEntity(HttpStatus.CREATED);
//	}
//
//	@Override
//	public ResponseEntity<?> getInventory() {
//		List<Book> inventory = bookRepository.findAll();
//		if(inventory != null && !inventory.isEmpty()) {
//			return new ResponseEntity<List<Book>>(inventory, HttpStatus.OK);
//		}
//		return new ResponseEntity(HttpStatus.BAD_REQUEST);
//	}
//
//	@Override
//	public ResponseEntity<?> updateBookInInventory(Long bookId, Book book) {
//		Optional<Book> searchedBook = bookRepository.findById(bookId);
//		if(!searchedBook.isEmpty() && searchedBook.get() != null) {
//			book.setBookId(bookId);
//			bookRepository.save(book);
//			return new ResponseEntity(HttpStatus.OK);
//		}
//		return new ResponseEntity(HttpStatus.BAD_REQUEST);
//	}
//
//	@Override
//	public ResponseEntity<?> removeBookFromInventory(Long bookId) {
//		Optional<Book> searchedBook = bookRepository.findById(bookId);
//		if(!searchedBook.isEmpty() && searchedBook.get() != null) {
//			searchedBook.get().setStock(0);
//			LOGGER.warn("REMOVED BOOK : " + bookRepository.save(searchedBook.get()).toString());
//		}
//		return null;
//	}
	
	
}
