package com.example.demo.config;

import static org.junit.Assert.assertEquals;

import com.example.demo.entity.UserM;
import com.example.demo.repository.UserRepositoryMongo;
import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;


@DataMongoTest
public class DataInitilizrTest {
  private MongodExecutable mongodExecutable;
  private MongoTemplate mongoTemplate;

  @InjectMocks
  DataInitilizr dataInitilizr;

  @Mock
  UserRepositoryMongo userRepositoryMongo;

  private static final String MONGO_DB_URL = "localhost";
  private static final String MONGO_DB_NAME = "embeded_db";



/*  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    String ip = "localhost";
    int port = 27017;

    IMongodConfig mongodConfig = new MongodConfigBuilder()
        .version(Version.Main.PRODUCTION)
        .net(new Net(ip, port, Network.localhostIsIPv6()))
        .build();

    MongodStarter starter = MongodStarter.getDefaultInstance();
    mongodExecutable = starter.prepare(mongodConfig);
    mongodExecutable.start();
    mongoTemplate = new MongoTemplate(new MongoClient(ip, port), "test");
  }*/

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
    mongo.setBindIp(MONGO_DB_URL);
    MongoClient mongoClient = mongo.getObject();
    mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
  }

  @Test
  public void mongoTest() {
    UserM userToBeSaved = new UserM("test", "1");
    Mockito.when(userRepositoryMongo.save(Mockito.any()))
        .thenReturn(mongoTemplate.save(userToBeSaved, "test"));
    //Mockito.when(userRepositoryMongo.findByName("test")).thenReturn(mongoTemplate.find)
    UserM test = dataInitilizr.methodForTest("test", "1");
    assertEquals("test", test.getName());
  }
}