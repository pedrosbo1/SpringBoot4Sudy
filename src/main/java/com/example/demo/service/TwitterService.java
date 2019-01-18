package com.example.demo.service;

import com.example.demo.entity.TwitterMessage;
import com.example.demo.entity.TwitterMessageTag;
import com.example.demo.exceptions.ApiError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class TwitterService {

  private static final Logger LOGGER = LoggerFactory.getLogger(SWAPIService.class);

  @Autowired
  TwitterAPIService twitterAPIService;

  @Autowired
  ImageService imageService;

  public List<TwitterMessage> getTweets(String twitterId) {
    String body;
    String url = "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name="+twitterId+"&count=100&trim_user=false";
    String token = "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX";

    try {
      body = twitterAPIService.callAPI(url,token);

    } catch (ApiError apiError) {
      apiError.printStackTrace();
      return null;
    }
    Type listType = new TypeToken<ArrayList<TwitterMessage>>() {}.getType();
    List<TwitterMessage> twitterMessageList = new Gson().fromJson(body, listType);
    return twitterMessageList;
  }

  public TwitterMessageTag searchTwitte(String keyword) {

    String body;
    String url = "https://api.twitter.com/1.1/search/tweets.json?q=" + keyword + "&count=100&result_type=popular";
    String token = "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX";
    try {
      body = twitterAPIService.callAPI(url,token);
    } catch (ApiError apiError) {
      apiError.printStackTrace();
      return null;
    }
    TwitterMessageTag twitterMessageTag = new Gson().fromJson(body, TwitterMessageTag.class);
    return twitterMessageTag;
  }
}
