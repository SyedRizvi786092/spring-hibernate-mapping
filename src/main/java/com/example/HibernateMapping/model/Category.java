package com.example.HibernateMapping.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "categories")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "category_id")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "categories")
//	@JsonManagedReference("products-categories")
	@JsonBackReference("products-categories")
	private Set<Product> products = new HashSet<>();
	
	public Category(String name) {
		super();
		this.name = name;
	}
}
