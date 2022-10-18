package com.yelproulette.yelp_roulette_artifact;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBTest {
    MongoDB mongoDB = new MongoDB();

    @Test
    public void testSearch() {
        boolean userFound = mongoDB.searchDocumentForUser("name", "Ivan");
        Assert.assertTrue("User not found", userFound);
    }
}
