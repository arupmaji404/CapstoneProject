package com.springboot.rest.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.rest.dao.BookRepository;
import com.springboot.rest.entities.Book;

@Component
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		return list;
		
	}

	@Override
	public Book getBookById(int bookId) {
		Book book = null;
		try
		{
			book=this.bookRepository.findById(bookId);
		}catch(NoSuchElementException a)
		{
			System.out.println("Please put valid request!!");
		}catch(Exception e)
		{
			System.out.println("Exception Caught!!");
		}
		return book;
	}

	@Override
	public Book addBook(Book b) {
				Book result=bookRepository.save(b);
				return result;
		
	}

	@Override
	public void deleteBook(int bId) {
		bookRepository.deleteById(bId);
		
	}

	@Override
	public void updateBook(Book book, int bookId) {
		book.setBookId(bookId);
		bookRepository.save(book);
		
	}

}
