package com.springboot.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
