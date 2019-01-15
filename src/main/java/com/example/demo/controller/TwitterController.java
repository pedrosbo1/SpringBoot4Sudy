package com.example.demo.controller;

import com.example.demo.entity.TwitterMessage;
import com.example.demo.entity.TwitterMessageTag;
import com.example.demo.service.MyWatsonService;
import com.example.demo.service.TwitterService;
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
  public ResponseEntity getTwiite(@RequestParam("name") String tweeterName) {
    String message = "";
    List<TwitterMessage> listOfTwitter = twitterService.getTweets(tweeterName);
    for (int i = 0; i < listOfTwitter.size(); i++) {
      message = message + "\n" + listOfTwitter.get(i).getMessage();
    }
    String result = myWatsonService.callWatson(message);
    return ResponseEntity.ok(result);
  }
  @GetMapping("/keywordtone")
  public ResponseEntity getToneKeyWord(@RequestParam("keyword") String keyWord) {
    String message = "";
    List<TwitterMessage> listOfTwitter = twitterService.seatchTwitte(keyWord).getStatuses();
    int end = listOfTwitter.size();
    for (int i = 0; i < end; i++) {
      message = message + "\n" + listOfTwitter.get(i).getMessage();
    }
    String result = myWatsonService.callWatson(message);
    return ResponseEntity.ok(result);
  }
}
