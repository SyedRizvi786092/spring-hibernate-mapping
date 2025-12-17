package com.example.HibernateMapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HibernateMapping.dto.UserDto;
import com.example.HibernateMapping.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> create(@RequestBody @Validated UserDto userDto) {
		return ResponseEntity.status(201).body(userService.createUser(userDto));
	}
	
	// TODO: getAll(), getById(Long)
}
