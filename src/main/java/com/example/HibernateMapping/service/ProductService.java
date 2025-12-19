package com.example.HibernateMapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HibernateMapping.model.Product;
import com.example.HibernateMapping.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
}
