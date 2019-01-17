package com.example.demo.service;

import static org.junit.Assert.*;

import com.example.demo.entity.TwitterMessage;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

public class TwitterServiceTest {

  @InjectMocks
  TwitterService twitterService;

  @Spy
  TwitterMessage twitterMessage;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getTweets() {

  }

  @Test
  public void seatchTwitte() {

  }

  @Test
  public void test4Test(){

    Mockito.doReturn("retorno").when(twitterMessage).getMessage();
    String a = twitterMessage.getMessage();
    String b = twitterService.test4Test();


    twitterMessage.setMessage("hello");
    Mockito.verify(twitterMessage).setMessage("hello");




    Mockito.verify(twitterMessage).setMessage("eae");
    assertTrue(twitterService.test4Test().equals("retorno"));
  }

}