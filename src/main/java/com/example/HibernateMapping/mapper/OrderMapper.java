package com.example.HibernateMapping.mapper;

import java.util.List;

import com.example.HibernateMapping.dto.OrderDto;
import com.example.HibernateMapping.model.Customer;
import com.example.HibernateMapping.model.Item;
import com.example.HibernateMapping.model.Order;

public class OrderMapper {
	
	public static Order toOrder(OrderDto orderDto) {
		Order order = new Order();
		order.setOrderNumber(orderDto.orderNumber());
		Customer customer = new Customer();
		customer.setId(orderDto.customerId());
		customer.addOrder(order);
		List<Item> itemList = orderDto.itemList().stream()
				.map(ItemMapper::toItem).toList();
		order.setItems(itemList);
		return order;
	}
}
