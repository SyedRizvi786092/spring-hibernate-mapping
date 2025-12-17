package com.example.HibernateMapping.mapper;

import com.example.HibernateMapping.dto.ProfileDto;
import com.example.HibernateMapping.model.Profile;

public class ProfileMapper {
	
	public static Profile toProfile(ProfileDto profileDto) {
		Profile profile = new Profile();
		profile.setFullName(profileDto.fullName());
		profile.setPhone(profileDto.phone());
		return profile;
	}
	
	public static ProfileDto toProfileDto(Profile profile) {
		return new ProfileDto(
			profile.getId(),
			profile.getFullName(),
			profile.getPhone()
			);
	}
}
