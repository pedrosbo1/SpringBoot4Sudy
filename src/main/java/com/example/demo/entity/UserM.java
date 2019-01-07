package com.example.demo.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserM {
	
	@Id
	private String Id;
	private String name;
	private String idade;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}

}
