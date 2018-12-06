package com.demo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.crud.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	Book findOneById(Long id);
}
