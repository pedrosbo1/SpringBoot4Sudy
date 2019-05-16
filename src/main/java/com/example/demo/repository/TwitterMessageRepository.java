package com.example.demo.repository;

import com.example.demo.entity.TwitterMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TwitterMessageRepository extends MongoRepository<TwitterMessage,Long> {
  TwitterMessage  findByMessage(String message);
}
