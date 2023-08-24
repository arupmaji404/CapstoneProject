package com.springboot.rest.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	@Column(name="email", unique=true)
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="address")
	private String address;
	
	
	@OneToMany(mappedBy="customers")
	@JsonBackReference
	private List<Book> book;


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<Book> getBook() {
		return book;
	}


	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Customer() {
		super();
	}

	public Customer(int customerId, String email, String password, String address, List<Book> book) {
	super();
	this.customerId = customerId;
	this.email = email;
	this.password = password;
	this.address = address;
	this.book = book;
	}

	@Override
	public String toString() {
		return "User [userId=" + customerId + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", book=" + book + "]";
	}
	
	
	
	
	
	
	

}
