package com.example.HibernateMapping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Embeddable
public class Address {
	@Column(length = 10)
	private String houseNo;
	
	@Column(name = "addr_landmark", length = 30)
	private String landmark;
	
	@Column(name = "addr_area", length = 50)
	private String area;
	
	@Column(name = "addr_city", length = 20)
	private String city;
	
	@Column(name = "addr_state", length = 20)
	private String state;
	
	@Column(length = 10)
	private String pinCode;
}
