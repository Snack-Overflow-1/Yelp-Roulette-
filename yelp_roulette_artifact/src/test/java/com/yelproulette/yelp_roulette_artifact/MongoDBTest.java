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
        boolean userfound = mongoDBService.searchDocumentForUser("name", "Dummy");
        Assert.assertTrue("USER WAS NOT FOUND IN DATABAES...", userfound);
    }
}
