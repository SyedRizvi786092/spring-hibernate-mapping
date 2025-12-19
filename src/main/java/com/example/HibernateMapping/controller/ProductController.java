package com.example.HibernateMapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HibernateMapping.model.Category;
import com.example.HibernateMapping.model.Product;
import com.example.HibernateMapping.service.CategoryService;
import com.example.HibernateMapping.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
		Product newProduct = new Product();
		newProduct.setName(product.getName());
		
		if(product.getCategories() != null) {
			product.getCategories().forEach(category -> {
				Category newCategory = categoryService.createCategory(category);
				newProduct.addCategory(newCategory);
			});
		}
		
		return ResponseEntity.status(201).body(productService.createProduct(newProduct));
	}
}
