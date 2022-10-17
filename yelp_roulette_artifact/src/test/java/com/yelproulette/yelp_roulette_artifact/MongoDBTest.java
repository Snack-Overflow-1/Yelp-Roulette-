package com.yelproulette.yelp_roulette_artifact;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MongoDBTest {

    @Test
    public void testSearch() {
        MongoDB mongoDB = new MongoDB();
        boolean userFound = mongoDB.searchDocumentForUser("name", "Ivan");
        Assert.assertTrue("User not found", userFound);
    }
}
