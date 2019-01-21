package com.example.demo.service;

import static org.junit.Assert.*;

import com.example.demo.entity.TwitterMessage;
import com.example.demo.entity.TwitterMessageTag;
import com.example.demo.exceptions.ApiError;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TwitterServiceTest {

  @InjectMocks
  TwitterService twitterService;

  @Mock
  TwitterAPIService twitterAPIService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getTweets() throws ApiError {
    Mockito.when(twitterAPIService.callAPI(
        "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=" + "eae"
            + "&count=100&trim_user=false",
        "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8"
            + "%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX"))
        .thenReturn("[{\"text\": \"batata\"},{\"text\": \"cenoura\"}]");
    List<TwitterMessage> list = twitterService.getTweets("eae");
    assertEquals(list.get(0).getMessage(), "batata");
    assertEquals(list.get(1).getMessage(), "cenoura");
  }
  @Test
  public void getTweetsError() throws ApiError {
    Mockito.when(twitterAPIService.callAPI(
        "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=" + "eae"
            + "&count=100&trim_user=false",
        "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8"
            + "%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX"))
        .thenThrow(ApiError.class);
    List<TwitterMessage> list = twitterService.getTweets("eae");
    assertEquals(list, null);
  }

  @Test
  public void searchTweets() throws ApiError {
    Mockito.when(twitterAPIService.callAPI(
        "https://api.twitter.com/1.1/search/tweets.json?q=" + "eae"
            + "&count=100&result_type=popular",
        "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8"
            + "%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX"))
        .thenReturn("{\"statuses\":[{\"text\": \"batata\"},{\"text\": \"cenoura\"}]}");
    TwitterMessageTag tw = twitterService.searchTweets("eae");
    assertEquals(tw.getStatuses().get(0).getMessage(), "batata");
    assertEquals(tw.getStatuses().get(1).getMessage(), "cenoura");
  }

  @Test
  public void searchTweetsError() throws ApiError {
    Mockito.when(twitterAPIService.callAPI(
        "https://api.twitter.com/1.1/search/tweets.json?q=" + "eae"
            + "&count=100&result_type=popular",
        "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8"
            + "%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX")).thenThrow(ApiError.class);
    TwitterMessageTag tw = twitterService.searchTweets("eae");
    assertEquals(tw,null);
  }
}