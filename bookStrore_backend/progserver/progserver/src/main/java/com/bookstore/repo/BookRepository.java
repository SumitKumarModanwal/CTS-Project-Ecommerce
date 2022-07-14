package com.bookstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;



@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book>  findByCategory(Category category);
}
