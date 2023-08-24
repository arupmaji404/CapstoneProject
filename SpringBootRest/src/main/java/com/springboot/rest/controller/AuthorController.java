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
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.entities.Author;
import com.springboot.rest.entities.Book;
import com.springboot.rest.services.AuthorService;

@RestController
public class AuthorController {
	
	//@RequestMapping(value="/authors",method=RequestMethod.GET)
	/*
	 * @GetMapping("/authors") public String getAuthor() { return
	 * "this is for testing purpose"; }
	 */
	
	//
	@Autowired
	private AuthorService authorService;
	
	//get all author handler
	@GetMapping("/authors")
	public ResponseEntity<List<Author>> getAuthors()
	{
		
		List<Author> list=authorService.getAllAuthors();
		System.out.println(list);
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
	}
	
	//get single author handler
	@GetMapping("/authors/{id}") // authors/1
	public ResponseEntity<Author> getAuthor(@PathVariable("id")int authorId)
	{
//		System.out.println("Hi");
//		System.out.println(authorId);
//		System.out.println("Hey");
		Author author=authorService.getAuthorById(authorId);
//		System.out.println("Bye");
//
//		System.out.println(author);		
//		System.out.println("See you");

		if(author==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(author));
		
	}
	
	//new author handler
	@PostMapping("/authors")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author)
	{
//		System.out.println(author);
		Author b=null;
		try {
			b=this.authorService.addAuthor(author);
			System.out.println(author);
			return ResponseEntity.of(Optional.of(author));
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
	
	//Delete author Handler
	@DeleteMapping("/authors/{aId}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable("aId") int authorId)
	{
		try {
			this.authorService.deleteAuthor(authorId);
			return ResponseEntity.status(HttpStatus.OK).build();
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//updating author handler
	@PutMapping("/authors/{authorId}")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author,@PathVariable("authorId") int authorId)
	{
		try {
			
			this.authorService.updateAuthor(author,authorId);
			return ResponseEntity.ok().body(author);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	
	}
	
	@GetMapping("/AuthorsBook/{id}") // books/1
	public ResponseEntity<List<Book>> getAuthorByBookId(@PathVariable("id")int authorId)
	{
//		System.out.println("Hi");
//		System.out.println(bookId);
//		System.out.println("Hey");
		Author author=authorService.getAuthorById(authorId);
//		System.out.println("Bye");
//
//		System.out.println(book);		
//		System.out.println("See you");
		List<Book> books = author.getBook();
		if(books.size()==0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(books));
		
	}
}

