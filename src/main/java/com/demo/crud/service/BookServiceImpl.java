package com.demo.crud.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.crud.entity.BookEntity;
import com.demo.crud.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<BookEntity> getBooks() {
		List<BookEntity> books = bookRepository.findAll();
		Collections.reverse(books);
		return books;
	}

	@Override
	public BookEntity getBook(long id) {
		return bookRepository.findOneById(id);
	}

	@Override
	public BookEntity createBook(BookEntity book) {
		return bookRepository.save(book);
	}

	@Override
	public BookEntity updateBook(BookEntity book) {
		BookEntity bookEntity = bookRepository.findOneById(book.getId());
		if (bookEntity == null) {
			return null;
		}
		
		BeanUtils.copyProperties(book, bookEntity);
		bookEntity = bookRepository.save(book);
		return bookEntity;
	}

	@Override
	public boolean deleteBook(long id) {
		BookEntity bookEntity = bookRepository.findOneById(id);
		if (bookEntity == null) {
			return false;
		}
		
		bookRepository.delete(bookEntity);
		return true;
	}

}
