package com.springboot.rest.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.rest.dao.AuthorRepository;
import com.springboot.rest.entities.Author;

//we can use @Service as well!!
@Component
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Author> getAllAuthors() {
		List<Author> list=(List<Author>)this.authorRepository.findAll();
		return list;
		
	}

	@Override
	public Author getAuthorById(int authorId) {
		Author author = null;
		try
		{
		//book = list.stream().filter(e -> e.getBookId() == bookId).findFirst().get();
			author=this.authorRepository.findById(authorId);
		}catch(NoSuchElementException a)
		{
			System.out.println("Please put valid request!!");
		}catch(Exception e)
		{
			System.out.println("Exception Caught!!");
		}
		return author;
		
	}

	@Override
	public Author addAuthor(Author a) {
		//list.add(b);
		Author result=authorRepository.save(a);
		return result;
	}

	@Override
	public void deleteAuthor(int aId) {
		//list = list.stream().filter(book -> book.getBookId() != bId).collect(Collectors.toList());
		authorRepository.deleteById(aId);
		
	}

	@Override
	public void updateAuthor(Author author, int authorId) {
		/*
		 * list = list.stream().map(b -> { if (b.getBookId() == bookId) {
		 * b.setBookTitle(book.getBookTitle()); b.setAuthor(book.getAuthor()); } return
		 * b; }).collect(Collectors.toList());
		 * 
		 */
		author.setAuthorId(authorId);
		authorRepository.save(author);
		
	}
	
	

}
