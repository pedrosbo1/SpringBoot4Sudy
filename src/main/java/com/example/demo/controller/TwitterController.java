package com.example.demo.controller;

import com.example.demo.entity.TwitterMessage;
import com.example.demo.service.MyWatsonService;
import com.example.demo.service.TwitterService;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tw")
public class TwitterController {

    @Autowired
    TwitterService twitterService;

    @Autowired
    MyWatsonService myWatsonService;

    @GetMapping("/twittetone")
    public ResponseEntity getTwiite(@RequestParam("name") String tweeterName ) {
        System.out.println(tweeterName);
        List<TwitterMessage> listOfTwitter = twitterService.getTweets(tweeterName);


        String message = "";
        for(int i=0;i<listOfTwitter.size();i++){
            message = message + "\n" + listOfTwitter.get(i).getMessage();
        }



        String result = myWatsonService.callWatson(message);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/keywordtone")
    public ResponseEntity getToneKeyWord(@RequestParam("keyword") String keyWord ) {
        System.out.println(keyWord);
        List<TwitterMessage> listOfTwitter = twitterService.seatchTwitte(keyWord);


        String message = "";
        for(int i=0;i<listOfTwitter.size();i++){
            message = message + "\n" + listOfTwitter.get(i).getMessage();
        }
        String result = myWatsonService.callWatson(message);

        return ResponseEntity.ok(result);
    }



}
