package com.example.demo.controller;

import com.example.demo.service.TweeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tw")
public class TweeterController {

    @Autowired
    TweeterService tweeterService;

    @GetMapping("/gettweet")
    public ResponseEntity getTweet(@RequestParam("name") String tweeterName ) {
        System.out.println(tweeterName);
        String tweets = tweeterService.getTweets(tweeterName);
        return ResponseEntity.ok(tweets);
    }


}
