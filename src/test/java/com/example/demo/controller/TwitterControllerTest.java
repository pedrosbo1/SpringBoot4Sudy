package com.example.demo.controller;

import static org.junit.Assert.*;

import com.example.demo.entity.TwitterMessage;
import com.example.demo.service.TwitterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestComponent;


public class TwitterControllerTest {

  TwitterMessage[] twitterMessage;

  @InjectMocks
  TwitterController twitterController;

  @Mock
  TwitterService twitterService;

  @Before
  public void setUp() throws Exception {
   // twitterController = new TwitterController();
    MockitoAnnotations.initMocks(this);
    twitterMessage = new TwitterMessage[10];
    twitterMessage[0] = new TwitterMessage();
  }

  @Test
  public void getTwiite() {
    Mockito.when(twitterService.getTweets(Mockito.any())).thenReturn(twitterMessage);
    String retorno = twitterController.getTwiite("eae").getBody().toString();


    assertTrue(twitterController.getTwiite("eae").getStatusCode().isError());
  }

  @Test
  public void getToneKeyWord() {
  }
}