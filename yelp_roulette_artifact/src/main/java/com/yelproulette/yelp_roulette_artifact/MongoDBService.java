/*
 * This class holds methods for starting a client runtime for the database and search methods.
 * The search methods searches by a title and the title's value and will return true if found and false otherwise.
 * 
 * I plan to add more MongoDB related methods to this MongoDBService Class if needed such as adding/deleting/updating information
 * in the database
 */

package com.yelproulette.yelp_roulette_artifact;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class MongoDBService {

    private static MongoClient mongoClient;
    private static DB database;
    private static DBCollection test;
    private static MongoCollection collection;

    /**
     * This method starts the client
     */
    public static void runTime() {
        // access the mongo database and create a MongoClient object from uri
        String uri = "mongodb+srv://dbtest:abcd1234@cluster0.elfhy1n.mongodb.net/test";
        MongoClientURI clienturi = new MongoClientURI(uri);
        mongoClient = new MongoClient(clienturi);

        // get the database and collection
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoclientdb");
        collection = mongoDatabase.getCollection("test");

    }

    /**
     * This method returns true if a user with a specific title and its value are
     * found... false otherwise
     * 
     * @param title      first parameter indicating the name of the value
     * @param titleValue type String holding the description of the title
     * @return True/False if the user containing both paramaters are found
     */
    public boolean searchDocumentForUser(String title, String titleValue) {
        boolean foundUser = false;
        Document found = (Document) collection.find(new Document(title,
                titleValue)).first();

        if (found != null) {
            System.out.println("Found user...");
            return foundUser = true;
        }
        System.out.println("User not found...");
        return foundUser;
    }

    /**
     * This method returns true if a user with a specific title and its value are
     * found... false otherwise
     * 
     * @param title      first parameter indicating the name of the value
     * @param titleValue type int holding the value of the title
     * @return True/False if the user containing both paramaters are found
     */
    public boolean searchDocumentForUserWithAge(String title, int titleValue) {
        boolean foundUser = false;
        Document found = (Document) collection.find(new Document(title,
                titleValue)).first();

        if (found != null) {
            System.out.println("Found user...");
            return foundUser = true;
        }
        System.out.println("User not found...");
        return foundUser;
    }

}
