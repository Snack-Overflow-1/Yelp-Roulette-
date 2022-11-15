package com.yelproulette.yelp_roulette_artifact;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.net.UnknownHostException;

public class MongoDBMain {

    public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection test;
    public static MongoCollection collection;

    public static void main(String[] args) {
        MongoDBMain mongodb = new MongoDBMain();
        String uri = "mongodb+srv://dbtest:abcd1234@cluster0.flvwqqy.mongodb.net/test";
        MongoClientURI clienturi = new MongoClientURI(uri);
        mongoClient = new MongoClient(clienturi);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoclientdb");
        collection = mongoDatabase.getCollection("test");

        Document document = new Document("name", "Kyle");
        document.append("Sex", "male");
        document.append("age", "24");
        document.append("race", "Human");

        // insert - add
        // delete
        // update

        // collection.insertOne(document);
        System.out.println("Database connected...");
        System.out.println(mongodb.searchDocumentForUser("name", "Kyle"));
    }

    // ----------------------------FINDING A USER AND UPDATING THEIR
    // DATA--------------------------
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
    // ----------------------------END FINDING A USER AND UPDATING THEIR
    // DATA-------------------------- }

    public boolean searchDocumentForUser(String name, String nameValue) {
        boolean foundUser = false;
        Document found = (Document) collection.find(new Document(name,
                nameValue)).first();

        if (found != null) {
            System.out.println("Found user...");
            return foundUser = true;
        }
        System.out.println("User not found...");
        return foundUser;
    }
}