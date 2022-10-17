package com.yelproulette.yelp_roulette_artifact;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.net.UnknownHostException;

import org.bson.Document;

public class MongoDB {

    public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection test;

    public static void main(String[] args) {
        String uri = "mongodb+srv://dbtest:abcd1234@cluster0.elfhy1n.mongodb.net/test";
        MongoClientURI clienturi = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(clienturi);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoclientdb");
        MongoCollection collection = mongoDatabase.getCollection("test");

        Document document = new Document("name", "Ivan");
        document.append("Sex", "male");
        document.append("age", "3");
        document.append("race", "butterfly");

        collection.insertOne(document);
    }
}
