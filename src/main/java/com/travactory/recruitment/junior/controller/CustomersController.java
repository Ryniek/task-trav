package com.travactory.recruitment.junior.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travactory.recruitment.junior.service.CustomersService;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private final CustomersService customersService;
	
	public CustomersController(CustomersService customersService) {
		this.customersService = customersService;
	}

	@GetMapping
	public ResponseEntity<?> getAllCustomers() {
		return ResponseEntity.ok(customersService.getAllCustomers());
	}
}
