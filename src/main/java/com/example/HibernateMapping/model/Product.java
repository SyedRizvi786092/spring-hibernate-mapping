package com.example.HibernateMapping.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "products1")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "product_id")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, unique = true)
	private String name;
	
	@ManyToMany
//	@JsonBackReference("products-categories")
	@JoinTable(
		name = "product_category",
			joinColumns = @JoinColumn(name = "product_id"), // FK to this "Product" entity
			inverseJoinColumns = @JoinColumn(name = "category_id") // FK to other entity
	)
	private Set<Category> categories = new HashSet<>();
	
	public void addCategory(Category c) {
		categories.add(c);
		c.getProducts().add(this);
	}
	
	public void removeCategory(Category c) {
		categories.remove(c);
		c.getProducts().remove(this);
	}
}
