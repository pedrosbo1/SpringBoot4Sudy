package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@ComponentScan("com.example.demo.config")
@Component
public class SWAPIService {
	@Autowired
	RestTemplate rest;

    public void callRestService(){
    	String uri = "https://swapi.co/api/people/1";
    	ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.GET,null,String.class);
    	System.out.println(responseEntity.getBody());
    }

}
