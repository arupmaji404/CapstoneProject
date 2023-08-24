package com.springboot.rest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.rest.entities.Author;

@Service
public interface AuthorService {
	
	public List<Author> getAllAuthors();
	public Author getAuthorById(int authorId);
	public Author addAuthor(Author a);
	public void deleteAuthor(int aId);
	public void updateAuthor(Author author, int authorId);
	

}
