package com.example.demo.service;

import com.example.demo.entity.TwitterMessage;
import com.example.demo.entity.TwitterMessageTag;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TwitterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SWAPIService.class);

    public List<TwitterMessage> getTweets(String twitterId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        headers.add("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=" + twitterId + "&count=10&trim_user=true", HttpMethod.GET, entity, String.class);
        //ResponseEntity<TwitterMessage> response = restTemplate.exchange("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name="+ twitterId +"&count=1&trim_user=true", HttpMethod.GET, entity, TwitterMessage.class);
        String body = response.getBody();

        Type listType = new TypeToken<ArrayList<TwitterMessage>>(){}.getType();
        List<TwitterMessage> twitterMessageList = new Gson().fromJson(body,listType);
        return twitterMessageList;
    }

    public TwitterMessageTag seatchTwitte(String keyword) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        headers.add("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        //ResponseEntity<TwitterMessageTag> response = restTemplate.exchange("https://api.twitter.com/1.1/search/tweets.json?q="+keyword+"&lang=pt&count=10&result_type=popular", HttpMethod.GET, entity, TwitterMessageTag.class);
        ResponseEntity<String> response = restTemplate.exchange("https://api.twitter.com/1.1/search/tweets.json?q=" + keyword + "&lang=pt&count=10&result_type=popular", HttpMethod.GET, entity, String.class);
        String body = response.getBody();
        LOGGER.info("Resposta" + body);
        TwitterMessageTag twitterMessageTag = new Gson().fromJson(body, TwitterMessageTag.class);
        return twitterMessageTag;
    }
}
