package com.example.HibernateMapping.mapper;

import com.example.HibernateMapping.dto.UserDto;
import com.example.HibernateMapping.model.User;

public class UserMapper {
	
	public static User toUser(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.username());
		user.setEmail(userDto.email());
		user.setProfile(ProfileMapper.toProfile(userDto.profile()));
		return user;
	}
	
	public static UserDto toUserDto(User user) {
		return new UserDto(
			user.getId(),
			user.getUsername(),
			user.getEmail(),
			ProfileMapper.toProfileDto(user.getProfile())
			);
	}
}
