package com.bookstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.service.BookService;



@RestController
@RequestMapping("/admin/books")
@CrossOrigin(origins = "*")
public class BookController {
//	private static final Logger LOGGER = LoggerFactory.getLogger("BOOK CONTROLLER - ADMIN");
	
	@Autowired
	private BookService bookService;
	
	
	
	@GetMapping("/")
	public ResponseEntity<?> getBooks() {
		return ResponseEntity.ok(bookService.getBooks());
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<?> getBook(@PathVariable("bookId") Long bookId) {
		return ResponseEntity.ok(bookService.getBook(bookId));
	}
	
	@GetMapping("/category/{categoryId}")
	public List<Book> getBooksOfCategory(@PathVariable("categoryId") Long categoryId){
		Category category=new Category();
		category.setCategoryId(categoryId);
		return this.bookService.getBooksOfCategory(category);
		
	}

	@PostMapping("/")
	public ResponseEntity<?> addBook(@RequestBody Book book){
		
		return ResponseEntity.ok(bookService.addBook(book));
	}

	@PutMapping("/")
	public ResponseEntity<?> updateBook( @RequestBody Book book) {
		return ResponseEntity.ok(bookService.addBook(book));
	}
	
	@DeleteMapping("/{bookId}")
	public void removeBook(@PathVariable("bookId") Long bookId){
		this.bookService.deleteBook(bookId);
		
	}
	
//	
//	// TODO - ADD File type in params
//	@PutMapping("/{bookId}/uploadImage")
//	public ResponseEntity<?> uploadImage(@PathVariable("bookId") Long bookId) {
//		return null;
//	}
//	
}
