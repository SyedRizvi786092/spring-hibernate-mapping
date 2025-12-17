package com.example.HibernateMapping.dto;

import java.util.List;

public record OrderDto(String orderNumber, Long customerId, List<ItemDto> itemList) {

}
