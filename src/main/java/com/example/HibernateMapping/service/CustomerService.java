package com.example.HibernateMapping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HibernateMapping.dto.CustomerDto;
import com.example.HibernateMapping.exception.InvalidIdException;
import com.example.HibernateMapping.exception.NotFoundException;
import com.example.HibernateMapping.mapper.CustomerMapper;
import com.example.HibernateMapping.model.Customer;
import com.example.HibernateMapping.model.Item;
import com.example.HibernateMapping.model.Order;
import com.example.HibernateMapping.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	public Customer createCustomer(CustomerDto customerDto) {
		return customerRepo.save(CustomerMapper.toCustomer(customerDto));
	}
	
	public Customer testCreateCustomer(Customer customer) {
		
		if (customer.getOrders() != null && !customer.getOrders().isEmpty()) {

	        // 1️ Make a copy
	        List<Order> incomingOrders = new ArrayList<>(customer.getOrders());

	        // 2️ Clear original list
	        customer.getOrders().clear();

	        // 3️ Re-add properly (sets FK)
	        for (Order order : incomingOrders) {
	            customer.addOrder(order);

	            //ALSO FIX ITEMS
	            if (order.getItems() != null && !order.getItems().isEmpty()) {

	                List<Item> incomingItems = new ArrayList<>(order.getItems());
	                order.getItems().clear();

	                for (Item item : incomingItems) {
	                    order.addItem(item);
	                }
	            }
	        }
	    }
		
		return customerRepo.save(customer);
	}
	
	public Customer getCustomerById(Long id) throws InvalidIdException, NotFoundException {
		if(id < 1 || id == null)
			throw new InvalidIdException("Invalid ID");
		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("Customer not found for ID "+id));
		return customer;
	}
	
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
}
