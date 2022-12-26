package com.travactory.recruitment.junior.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travactory.recruitment.junior.model.Customer;
import com.travactory.recruitment.junior.repository.CustomersRepository;

@Service
public class CustomersService {

	private final CustomersRepository customersRepository;

	public CustomersService(CustomersRepository customersRepository) {
		super();
		this.customersRepository = customersRepository;
	}
	
	public List<Customer> getAllCustomers() {
		return customersRepository.findAll();	
	}
}
