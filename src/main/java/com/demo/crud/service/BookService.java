package com.demo.crud.service;

import java.util.List;

import com.demo.crud.entity.Book;

public interface BookService {
	List<Book> getBooks();
	Book getBook(long id);
	Book createBook(Book book);
	Book updateBook(Book book);
	boolean deleteBook(long id);
}
