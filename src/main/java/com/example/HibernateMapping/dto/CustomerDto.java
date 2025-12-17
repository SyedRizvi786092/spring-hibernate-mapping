package com.example.HibernateMapping.dto;

import java.util.List;

import com.example.HibernateMapping.model.Address;

public record CustomerDto(String name, String email, Address address, List<OrderDto> orderList) {

}
