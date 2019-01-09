package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.entity.UserM;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRepositoryMongo;
import com.example.demo.service.SWAPIService;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRepositoryMongo userRepositoryMongo;
	
	@Autowired
	SWAPIService Swapi;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//sempre é chamado na inicialização, pode ser usado como configuração

		addUser("Pedro",21);
		addUser("Armando",22);
		addUser("Daniele",35);
		addUser("Otavio",100);
		
		addUserM("batata","1");
		
		
		User user1 = userRepository.findByName("Pedro");
		System.out.println(user1.getName());
		
		//Swapi.callRestService();
		
		//UserM userM = userRepositoryMongo.findByName("batata");
		//System.out.println(userM.getName());
		
	}
	
	private void addUser(String nome,int idade) {
		User user = new User();
		user.setIdade(idade);
		user.setName(nome);
		userRepository.save(user);
	}
	
	private void addUserM(String nome,String idade) {
		UserM user = new UserM();
		user.setIdade(idade);
		user.setName(nome);
		userRepositoryMongo.save(user);
	}

}
