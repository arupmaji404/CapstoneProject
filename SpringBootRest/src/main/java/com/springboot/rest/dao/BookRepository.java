package com.springboot.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.entities.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{
	
	public Book findById(int bookId);

}
