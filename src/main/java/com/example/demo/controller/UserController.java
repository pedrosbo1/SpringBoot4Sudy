package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/Users")
	public List<User> getUsers() {
		System.out.println("chegou na bagaça da rota");
		return userService.getListOfUsers();
	}

}
