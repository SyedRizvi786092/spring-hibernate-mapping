package com.example.HibernateMapping.mapper;

import java.util.List;

import com.example.HibernateMapping.dto.CustomerDto;
import com.example.HibernateMapping.model.Customer;
import com.example.HibernateMapping.model.Order;

public class CustomerMapper {
	
	public static Customer toCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setName(customerDto.name());
		customer.setEmail(customerDto.email());
		customer.setAddress(customerDto.address());
		List<Order> orderList = customerDto.orderList().stream()
				.map(OrderMapper::toOrder)
				.toList();
		customer.setOrders(orderList);
		return customer;
	}
}
