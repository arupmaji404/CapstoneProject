package com.springboot.rest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.rest.entities.Book;

@Service
public interface BookService {
	
	public List<Book> getAllBooks();
	public Book getBookById(int bookId);
	public Book addBook(Book b);
	public void deleteBook(int bId);
	public void updateBook(Book book, int bookId);

}
