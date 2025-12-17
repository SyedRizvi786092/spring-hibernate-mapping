package com.example.HibernateMapping.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, unique = true, length = 50)
	private String username;
	
	@Email
	@Column(nullable = false, unique = true)
	private String email;
	
	@CreationTimestamp
	private Instant createdAt;
	
	@UpdateTimestamp
	private Instant updatedAt;
	
	// Defining 1:1 link with Profile
	@OneToOne(mappedBy = "user", // -> NON-OWNING SIDE (The other side "Profile" owns the foreign key column)
			cascade = CascadeType.ALL, // -> Operations like save and delete etc. apply to Profile also
			orphanRemoval = true, // -> If we remove Profile reference from User, Hibernate deletes Profile row from profile table permanently
			fetch = FetchType.LAZY) // -> Profile is loaded only when accessed (improves performance)
	@JsonManagedReference("user-profile") // To stop recursive calls
	private Profile profile;
	
	public void setProfile(Profile profile) {
		this.profile = profile;
		if(profile != null)
			profile.setUser(this);
	}
}
