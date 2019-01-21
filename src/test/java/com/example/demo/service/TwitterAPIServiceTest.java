package com.example.demo.service;

import static org.junit.Assert.*;

import com.example.demo.exceptions.ApiError;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TwitterAPIServiceTest {

  @InjectMocks
  TwitterAPIService twitterAPIService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void callAPI() throws ApiError {
    String body = twitterAPIService.callAPI(
        "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=" + "eae"
            + "&count=2&trim_user=false",
        "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8"
            + "%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX");
    assertTrue(body.contains("\"text\":"));
  }

  @Test
  public void callAPI2() throws ApiError {
    String body = twitterAPIService.callAPI(
        "https://api.twitter.com/1.1/search/tweets.json?q=" + "eae"
            + "&count=2&result_type=popular",
        "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8"
            + "%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX");
    assertTrue(body.contains("{\"statuses\":"));
  }

  @Test(expected = ApiError.class)
  public void testThrows() throws ApiError {
    String body = twitterAPIService.callAPI(
        "https://api.twitter.com/1.1/search/tweets.json?q=" + ""
            + "&count=2&result_type=popular",
        "Bearer AAAAAAAAAAAAAAAAAAAAAGUY6AAAAAAA35b1KsdwTRmwAB%2FU16GJXeSRXv8"
            + "%3DnEKkx6QmRRXaTPcHBSHOs63H7eN9xr7QrRehdFTYeTIDjoZQjX");
  }
}