package com.example.HibernateMapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HibernateMapping.dto.CustomerDto;
import com.example.HibernateMapping.exception.InvalidIdException;
import com.example.HibernateMapping.exception.NotFoundException;
import com.example.HibernateMapping.model.Customer;
import com.example.HibernateMapping.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody @Valid CustomerDto request) {
		return ResponseEntity.status(201).body(customerService.createCustomer(request));
	}
	
	@PostMapping("/test")
	public ResponseEntity<Customer> testCreate(@RequestBody @Valid Customer customer) {
		return ResponseEntity.status(201).body(customerService.testCreateCustomer(customer));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getById(@PathVariable Long id) throws InvalidIdException, NotFoundException {
		return ResponseEntity.ok(customerService.getCustomerById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAll() {
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
}
