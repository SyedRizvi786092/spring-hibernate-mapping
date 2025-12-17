package com.example.HibernateMapping.mapper;

import com.example.HibernateMapping.dto.ItemDto;
import com.example.HibernateMapping.model.Item;
import com.example.HibernateMapping.model.Order;

public class ItemMapper {
	
	public static Item toItem(ItemDto itemDto) {
		Item item = new Item();
		item.setQuantity(itemDto.quantity());
		Order order = new Order();
		order.setId(itemDto.orderId());
		order.addItem(item);
		return item;
	}
}
