package com.example.HibernateMapping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "profiles")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String fullName;
	
	@NotBlank
	private String phone;
	
	// Defines 1:1 linking with User
	// No mappedBy here means that this is a OWNING SIDE
	@OneToOne(fetch = FetchType.LAZY)
	// Creates an actual foreign key column in profile table named "user_id"
	@JoinColumn(name = "user_id",
				nullable = false, // -> Each Profile must belong to one User
				unique = true) // -> One Profile per User
	@JsonBackReference("user-profile") // To stop recursive calls
	private User user;
}
