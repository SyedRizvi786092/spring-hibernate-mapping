package com.example.HibernateMapping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.HibernateMapping.model.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
