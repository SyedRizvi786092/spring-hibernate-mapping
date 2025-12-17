package com.example.HibernateMapping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.HibernateMapping.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
