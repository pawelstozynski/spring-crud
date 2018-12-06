package com.demo.crud;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.crud.entity.Book;
import com.demo.crud.service.BookService;

@Component
public class InitData {

	@Autowired
	private BookService bookService;
	
	@PostConstruct
	private void init() {
		Book book1 = new Book("Thinking in Java", "Bruce Eckell", 1248);
		Book book2 = new Book("Clean Code", "Robert C. Martin", 464);
		
		bookService.createBook(book1);
		bookService.createBook(book2);
	}
	
}
