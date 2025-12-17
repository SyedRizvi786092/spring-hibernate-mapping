package com.example.HibernateMapping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HibernateMapping.dto.UserDto;
import com.example.HibernateMapping.mapper.UserMapper;
import com.example.HibernateMapping.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public UserDto createUser(UserDto userDto) {
		return UserMapper.toUserDto(userRepo.save(UserMapper.toUser(userDto)));
	}
	
	public List<UserDto> getAllUsers() {
		List<UserDto> listOfUsers = new ArrayList<>();
		userRepo.findAll().forEach(user -> listOfUsers.add(UserMapper.toUserDto(user)));
		return listOfUsers;
	}
	
	// TODO: getUserById()
}
