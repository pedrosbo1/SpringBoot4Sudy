package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import com.example.demo.entity.UserM;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
//@Import(TestConfig.class)
@TestPropertySource( locations = "classpath:application-test.properties")
public class ServiceToBeTestedTest {


  @Autowired
  private ServiceToBeTested serviceToBeTested;

  @Test
  public void name() {
    UserM userM = new UserM("pedro", "22");
    assertEquals(userM, serviceToBeTested.escreveNoBanco(userM));
  }
}