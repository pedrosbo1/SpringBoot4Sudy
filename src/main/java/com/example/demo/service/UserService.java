package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


@Component
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getListOfUsers(){
		return userRepository.findAll();
	}


}