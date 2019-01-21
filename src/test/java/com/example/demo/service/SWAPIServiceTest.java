package com.example.demo.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class SWAPIServiceTest {

  @InjectMocks
  SWAPIService swapiService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void callRestService() {
    swapiService.callRestService();
  }


}