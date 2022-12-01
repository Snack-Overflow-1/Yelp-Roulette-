package com.yelproulette.yelp_roulette_artifact;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.net.UnknownHostException;

public class MongoDBTest {

    public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection test;
    public static MongoCollection collection;
    public final static String uri = "mongodb+srv://dbtest:abcd1234@cluster0.flvwqqy.mongodb.net/test";

    public static void main(String[] args) {
        try {
            MongoClientURI clienturi = new MongoClientURI(uri);
            mongoClient = new MongoClient(clienturi);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoclientdb");
            collection = mongoDatabase.getCollection("test");
            Document document = new Document();

            MongoDBService mdbs = new MongoDBService();
            // mdbs.addUserToDatabase("Dummy2", "Placeholder", "email@email.com", 1);

            // Search the database with a given title and name if the user exists
            System.out.println(mdbs.searchDocumentForUser("_id", "6386ec5194017c6da6409374"));
            System.out.println(document.get("_id"));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

// ----------FINDING A USER AND UPDATING THEIR DATA----------
// Document search = new Document("name", "Ivan");
// Document found = (Document) collection.find(new Document("name",
// "Ivan")).first();

// if (found != null) {
// System.out.println("Found user...");

// Bson updatedValue = new Document("age", 5);
// Bson updateOperation = new Document("$set", updatedValue);
// collection.updateOne(found, updateOperation);
// System.out.println("User updated...");
// }
// ----------END FINDING A USER AND UPDATING THEIR DATA----------

// ----------EXAMPLE ON HOW TO ADD ONTO MONGODB-----------
// Document document = new Document("name", "Kyle");
// document.append("Sex", "male");
// document.append("age", "24");
// document.append("race", "Human");
// collection.insertOne(document);
// ----------END EXAMPLE ON HOW TO ADD ONTO MONGODB-----------

// ----------OTHER BUILT IN METHODS----------
// collection.insert - add
// collection.delete
// collection.update
// ----------END OTHER BUILT IN METHODS----------
