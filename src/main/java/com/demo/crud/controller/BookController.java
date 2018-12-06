package com.demo.crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.demo.crud.entity.BookEntity;
import com.demo.crud.exception.ResourceNotFoundException;
import com.demo.crud.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("bookList", bookService.getBooks());
		return "book/index";
	}
	
	@GetMapping(path = "book/create")
	public String createBook(@ModelAttribute("book") BookEntity book) {
		return "book/create";
	}

	@PostMapping(path = "book/create")
	public String createBook(@Valid @ModelAttribute("book") BookEntity book, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "book/create";
		}

		bookService.createBook(book);
		return "redirect:/";
	}
	
	@GetMapping(path="book/edit/{id}")
	public String updateBook(@PathVariable long id, Model model) {
		BookEntity book = bookService.getBook(id);
		if (book == null) {
			throw new ResourceNotFoundException();
		}
		model.addAttribute("book", book);
		return "book/edit";
	}
	
	@PutMapping(path="book/edit/{id}")
	public String updateBook(@PathVariable long id, @Valid @ModelAttribute("book") BookEntity book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "book/edit";
		}
		
		if(bookService.updateBook(book) == null) {
			throw new ResourceNotFoundException();
		}
		return "redirect:/";
	}

	@DeleteMapping(path = "book/{id}")
	public String deleteBook(@PathVariable long id) {
		if (bookService.deleteBook(id) == false) {
			throw new ResourceNotFoundException();
		}
		return "redirect:/";
	}

}
