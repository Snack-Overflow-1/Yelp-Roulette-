package com.yelproulette.yelp_roulette_artifact;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.net.UnknownHostException;

public class MongoDB {

    public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection test;
    public static MongoCollection collection;

    public static void main(String[] args) {
        String uri = "mongodb+srv://dbtest:abcd1234@cluster0.elfhy1n.mongodb.net/test";
        MongoClientURI clienturi = new MongoClientURI(uri);
        mongoClient = new MongoClient(clienturi);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoclientdb");
        collection = mongoDatabase.getCollection("test");

        Document document = new Document("name", "Ivan");
        document.append("Sex", "never");
        document.append("age", "3");
        document.append("race", "400m");

        // insert - add
        // delete
        // update

        // collection.insertOne(document);
        System.out.println("Database connected...");
        searchDocumentForUser("name", "Ivan");

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
    }

    public boolean searchDocumentForUser(String name, String nameValue) {
        boolean foundUser = false;
        Document found = (Document) collection.find(new Document(name,
                nameValue)).first();

        if (found != null) {
            System.out.println("Found user...");
            return foundUser = true;
        }
        return foundUser = false;
    }
}
