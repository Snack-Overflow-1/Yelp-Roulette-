package com.kellyj.junit;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.net.UnknownHostException;

import org.bson.Document;
import org.bson.conversions.Bson;

@SpringBootApplication
public class KellyJUNIT {

	public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection test;
    public static MongoCollection collection; 

    public static void runningtime() {
        String uri = "mongodb+srv://snackoverflow:snackoverflowed@cluster0.tfsgthl.mongodb.net/test"; 
        MongoClientURI clienturi = new MongoClientURI(uri);
        mongoClient = new MongoClient(clienturi);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoclientdb");
        collection = mongoDatabase.getCollection("test");

        Document document = new Document("name", "Ivan");
        document.append("Sex", "Non-binary");
        document.append("Age", "29");
        document.append("Race", "Human");
    }


	public static void main(String[] args) {
		//SpringApplication.run(KellyJUNIT.class, args);

		// String uri = "mongodb+srv://snackoverflow:snackoverflowed@cluster0.tfsgthl.mongodb.net/test"; 
		// MongoClientURI clienturi = new MongoClientURI(uri);
        // MongoClient mongoClient = new MongoClient(clienturi);

        // MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoclientdb");
        // MongoCollection collection = mongoDatabase.getCollection("test");

        // Document document = new Document("name", "Ivan");
        // document.append("Sex", "Non-binary");
        // document.append("Age", "29");
        // document.append("Race", "Human");

        runningtime(); 

        //collection.insertOne(document); 

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
