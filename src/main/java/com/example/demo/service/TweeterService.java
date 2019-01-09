package com.example.demo.service;

import com.example.demo.entity.TweeterMessage;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class TweeterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SWAPIService.class);

    public String getTweets(String tweeterId){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        headers.add("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX");

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


        ResponseEntity<String> response = restTemplate.exchange("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name="+ tweeterId +"&count=2&trim_user=true", HttpMethod.GET, entity,String.class);
        //ResponseEntity<TweeterMessage> response = restTemplate.exchange("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name="+ tweeterId +"&count=2&trim_user=true", HttpMethod.GET, entity, TweeterMessage.class);

        LOGGER.info("Resposta" + response.getBody());
        return response.getBody();

    }



}
