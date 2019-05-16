package com.example.demo.service;

import com.example.demo.entity.UserM;
import com.example.demo.repository.UserRepositoryMongo;
import org.springframework.stereotype.Service;

@Service
public class ServiceToBeTested {

  private UserRepositoryMongo userRepositoryMongo;

  public ServiceToBeTested(UserRepositoryMongo userRepositoryMongo) {
    this.userRepositoryMongo = userRepositoryMongo;
  }

  public UserM escreveNoBanco(UserM userM) {
    return userRepositoryMongo.save(userM);
  }
}
