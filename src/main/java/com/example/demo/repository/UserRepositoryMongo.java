package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.UserM;

public interface UserRepositoryMongo extends MongoRepository<UserM, Long > {
	
	UserM findByName(String name);

}
