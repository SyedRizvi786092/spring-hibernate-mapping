package com.example.HibernateMapping.dto;

public record UserDto(Long id, String username, String email, ProfileDto profile) {

}
