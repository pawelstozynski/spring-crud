package com.demo.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "book")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 60, message="Must be between 1 and 60")
	private String title;
	
	@NotNull
	@Size(min = 1, max = 60, message = "Must be between 1 and 60")
	private String author;
	
	@NotNull
	@Min(value=1, message="Must be greater than 0")
	private Integer pages;
	
	public Book(String title, String author, int pages) {
		this.title = title;
		this.author = author;
		this.pages = pages;
	}
	
}
