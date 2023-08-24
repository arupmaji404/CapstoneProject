package com.springboot.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customer")
public class CustomerController {
	
	@GetMapping("/")
	public String getCustomer()
	{
		return "get customer";
	}

}
