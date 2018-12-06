package com.demo.crud.service;

import java.util.List;

import com.demo.crud.entity.BookEntity;

public interface BookService {
	List<BookEntity> getBooks();
	BookEntity getBook(long id);
	BookEntity createBook(BookEntity book);
	BookEntity updateBook(BookEntity book);
	boolean deleteBook(long id);
}
