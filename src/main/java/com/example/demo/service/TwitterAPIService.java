package com.example.demo.service;

import com.example.demo.exceptions.ApiError;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Arrays;

@Component
public class TwitterAPIService {

  public String callAPI(String url, String autentication) throws ApiError {
    ResponseEntity<String> response;
    String body;
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity;
    Type listType;

    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
    headers.add("Authorization",
        autentication);
    entity = new HttpEntity<String>("parameters", headers);
    try {
      response = restTemplate.exchange(
          url, HttpMethod.GET, entity, String.class);
    }catch(Exception e){
        throw new ApiError("Bad Request");
      }

    if(response.getStatusCode().is2xxSuccessful()){
      body = response.getBody();
      return body;
    }else{
      throw new ApiError(Integer.toString(response.getStatusCode().value()));
    }
  }
}
