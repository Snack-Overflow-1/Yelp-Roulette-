package com.example.junit.junit;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.net.UnknownHostException;

public class MongoDB {

    public static MongoClient mongoClient;
    public static MongoCollection collection;

    public static void runningtime() {
        String uri = "mongodb+srv://SnackMongoy:TeemMqL6RtdyVCWc@snackoverflowmongo.3uyb2ff.mongodb.net/?retryWrites=true&w=majority";
        MongoClientURI clienturi = new MongoClientURI(uri);
        mongoClient = new MongoClient(clienturi);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("SnackOverflowMongo");
        collection = mongoDatabase.getCollection("Yelp-API");

        Document document = new Document();
        document.append("Origin", "Ethipoia");
        document.append("Color", "Purple");
        document.append("Price", 16);

        collection.insertOne(document);
    }

    public static void main(String[] args) {
        runningtime();

        System.out.println("Database connected...");
        search("Origin", "Ethipoia");
    }

    public static boolean search(String item, String key) {
        Document res = (Document) collection.find(new Document(item, key)).first();

        if(res == null) {
            System.out.println("Not available");
            return false;
        }
        System.out.println("Found key");
        return true;
        
    }
}