package com.travactory.recruitment.junior.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travactory.recruitment.junior.model.Customer;

public interface CustomersRepository extends JpaRepository<Customer, Integer> {
	Optional<Customer> findById(Integer id);
}
