package com.springboot.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer>{
	
	public Author findById(int authorId);

}
