package com.example.demo.controller;

import static org.junit.Assert.*;

import com.example.demo.entity.TwitterMessage;
import com.example.demo.entity.TwitterMessageTag;
import com.example.demo.service.MyWatsonService;
import com.example.demo.service.TwitterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
    TwitterMessage twitterMessage1 = new TwitterMessage();
    TwitterMessage twitterMessage2 = new TwitterMessage();
    twitterMessages = new ArrayList<TwitterMessage>();
    twitterMessageTag = new TwitterMessageTag();

    twitterMessage1.setMessage("mensagem");
    twitterMessage2.setMessage("mocada");

    twitterMessages.add(twitterMessage1);
    twitterMessages.add(twitterMessage2);

    twitterMessageTag.setStatuses(twitterMessages);
  }

  @Test
  public void getTwiite() {
    Mockito.when(twitterService.getTweets(Mockito.any())).thenReturn(twitterMessages);
    Mockito.when(myWatsonService.callWatson("\nmensagem\nmocada")).thenReturn("ok");
    String retorno = twitterController.getTwiite(Mockito.anyString()).getBody().toString();
    assertTrue(retorno.equals("ok"));
  }

  @Test
  public void getToneKeyWord() {
    Mockito.when(twitterService.searchTwitte(Mockito.anyString())).thenReturn(twitterMessageTag);
    Mockito.when(myWatsonService.callWatson("\nmensagem\nmocada")).thenReturn("ok");
    String retorno = twitterController.getToneKeyWord(Mockito.anyString()).getBody().toString();
    assertTrue(retorno.equals("ok"));
  }
}