package com.example.demo.service;

import com.example.demo.entity.PersonSW;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@ComponentScan("com.example.demo.config")
@Component
public class SWAPIService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SWAPIService.class);

	@Autowired
	RestTemplate rest;

	@Async
    public void callRestService(){
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
			headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

			//há duas maneiras de pegar a mensagem, a primeira é pegando toda a mensagem com uma classe generica, pode ser a String ou Object
			//a segunda é mapeando o request em um objeto, porem é preciso conhecer a estrutura do serviço

			//1° forma
			//ResponseEntity<String> response = restTemplate.exchange("https://swapi.co/api/people/1", HttpMethod.GET, entity,String.class);

			//2° forma
			ResponseEntity<PersonSW> response = restTemplate.exchange("https://swapi.co/api/people/1", HttpMethod.GET, entity, PersonSW.class);

			//1° forma
			//LOGGER.info("Resposta" + response.getBody());

			//2° forma
			LOGGER.info("Nome:" + response.getBody().getName());


		}catch(Exception e){
			LOGGER.error(e.getMessage());
		}
    }

}
