package com.springboot.rest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bookId")
	private int bookId;
	@Column(name="bookTitle")
	private String bookTitle;

	@ManyToOne
//	(cascade=CascadeType.ALL)
//	@JsonManagedReference
	private Author author;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book(int bookId, String bookTitle, Author author) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", author=" + author + "]";
	}
	
}
