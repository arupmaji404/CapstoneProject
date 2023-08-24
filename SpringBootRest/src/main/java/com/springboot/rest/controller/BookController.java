package com.springboot.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.entities.Author;
import com.springboot.rest.entities.Book;
import com.springboot.rest.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//get all book handler
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		
		List<Book> list=bookService.getAllBooks();
		System.out.println(list);
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
	}
	
	//get single book handler
	@GetMapping("/books/{id}") // books/1
	public ResponseEntity<Book> getBook(@PathVariable("id")int bookId)
	{

		Book book=bookService.getBookById(bookId);

		if(book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
		
	}
	
	//new book handler
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		System.out.println(book);
		Book b=null;
		try {
			b=this.bookService.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(book));
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
	
	//Delete book Handler
	@RequestMapping("/books/{bId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bId") int bookId)
	{
		try {
			this.bookService.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.OK).build();
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//updating book handler
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		try {
			
			this.bookService.updateBook(book,bookId);
			return ResponseEntity.ok().body(book);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	
	}
	
	@GetMapping("/booksAuthor/{id}") // books/1
	public ResponseEntity<Author> getAuthorByBookId(@PathVariable("id")int bookId)
	{
		Book book=bookService.getBookById(bookId);
		Author author = book.getAuthor();
		if(author==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(author));
		
	}
}

