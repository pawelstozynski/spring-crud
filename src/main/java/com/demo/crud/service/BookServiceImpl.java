package com.demo.crud.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.crud.entity.Book;
import com.demo.crud.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getBooks() {
		List<Book> books = bookRepository.findAll();
		Collections.reverse(books);
		return books;
	}

	@Override
	public Book getBook(long id) {
		return bookRepository.findOneById(id);
	}

	@Override
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		Book bookEntity = bookRepository.findOneById(book.getId());
		if (bookEntity == null) {
			return null;
		}
		
		BeanUtils.copyProperties(book, bookEntity);
		bookEntity = bookRepository.save(book);
		return bookEntity;
	}

	@Override
	public boolean deleteBook(long id) {
		Book bookEntity = bookRepository.findOneById(id);
		if (bookEntity == null) {
			return false;
		}
		
		bookRepository.delete(bookEntity);
		return true;
	}

}
