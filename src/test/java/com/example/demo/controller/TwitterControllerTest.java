package com.example.demo.controller;

import static org.junit.Assert.*;

import com.example.demo.entity.TwitterMessage;
import com.example.demo.entity.TwitterMessageTag;
import com.example.demo.service.MyWatsonService;
import com.example.demo.service.TwitterService;
import com.ibm.watson.developer_cloud.service.WatsonService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestComponent;

import java.util.ArrayList;
import java.util.List;


public class TwitterControllerTest {

  List<TwitterMessage> twitterMessages;
  TwitterMessageTag twitterMessageTag;

  @InjectMocks
  TwitterController twitterController;

  @Mock
  TwitterService twitterService;

  @Mock
  MyWatsonService myWatsonService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    twitterMessages = new ArrayList<TwitterMessage>();
    twitterMessages.add(new TwitterMessage());
    twitterMessageTag = new TwitterMessageTag();
    twitterMessageTag.setStatuses(twitterMessages);
  }

  @Test
  public void getTwiite() {
    Mockito.when(twitterService.getTweets(Mockito.any())).thenReturn(twitterMessages);
    Mockito.when(myWatsonService.callWatson(Mockito.anyString())).thenReturn("ok");
    String retorno = twitterController.getTwiite(Mockito.anyString()).getBody().toString();
    assertTrue(retorno.equals("ok"));
  }

  @Test
  public void getToneKeyWord() {
    Mockito.when(twitterService.seatchTwitte(Mockito.anyString())).thenReturn(twitterMessageTag);
    Mockito.when(myWatsonService.callWatson(Mockito.anyString())).thenReturn("eae");
    String retorno = twitterController.getToneKeyWord(Mockito.anyString()).getBody().toString();
    assertTrue(retorno.equals("eae"));
  }
}