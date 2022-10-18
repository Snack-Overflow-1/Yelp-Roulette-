package com.yelproulette.yelp_roulette_artifact;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.Before;

public class MongoDBTest {
    @Before
    public void initialize() {
        System.out.println("Running test...");
    }

    @Test
    public void findUserTest1() {
        MongoDBService mongoDBService = new MongoDBService();
        MongoDBService.runTime();
        boolean userfound = mongoDBService.searchDocumentForUser("name", "Ivan");
        Assert.assertTrue("USER WAS NOT FOUND...", userfound);
    }

    @Test
    public void findUserTest2() {
        MongoDBService mongoDBService = new MongoDBService();
        MongoDBService.runTime();
        boolean userfound = mongoDBService.searchDocumentForUser("race", "400m");
        Assert.assertTrue("USER WAS NOT FOUND...", userfound);
    }

    @Test
    public void findUserTest3() {
        MongoDBService mongoDBService = new MongoDBService();
        MongoDBService.runTime();
        boolean userfound = mongoDBService.searchDocumentForUserWithAge("age", 5);
        Assert.assertTrue("USER WAS NOT FOUND...", userfound);
    }
}
