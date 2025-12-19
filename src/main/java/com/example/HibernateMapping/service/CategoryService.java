package com.example.HibernateMapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HibernateMapping.model.Category;
import com.example.HibernateMapping.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Category createCategory(Category category) {
		return categoryRepo.save(new Category(category.getName()));
	}
}
