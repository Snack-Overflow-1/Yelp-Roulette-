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
import org.bson.conversions.Bson;

import java.net.UnknownHostException;

public class MongoDBService {

    private static MongoClient mongoClient;
    private static DB database;
    private static DBCollection test;
    private static MongoCollection collection;
    // creating a cursor for searching through the database
    private static DBCursor cursor;

    /**
     * This method starts the client
     */
    public static void runTime() {
        // access the mongo database and create a MongoClient object from uri
        // String uri =
        // "mongodb+srv://dbtest:abcd1234@cluster0.elfhy1n.mongodb.net/test";
        String uri = "mongodb+srv://dbtest:abcd1234@cluster0.flvwqqy.mongodb.net/test";
        MongoClientURI clienturi = new MongoClientURI(uri);
        mongoClient = new MongoClient(clienturi);

        // get the database and collection
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoclientdb");
        collection = mongoDatabase.getCollection("test");
        System.out.println("Database connected...");
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
        runTime();
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
     * This method returns the Document of a user from a specfic title and value
     * within the MongoDB Collection
     * 
     * @param title      String of the title
     * @param titleValue String value of the given title
     * @return BSON format of the information from that Document that was found
     */
    public Document getUserWithString(String title, String titleValue) {
        runTime();
        Document found = null;
        boolean bool = searchDocumentForUser(title, titleValue);
        if (bool == true) {
            Document search = new Document(title, titleValue);
            found = (Document) collection.find(search).first();
            return found;
        }
        return found;
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
        runTime();
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
     * This method adds a user with given paramaters as data into MongoDB. It
     * appends all data parameters... connects to the database with the runtime...
     * prints to console that it is connected... then uploads the parameters to
     * MongoDB
     * 
     * @param firstName String of the name of the user we want to add
     * @param lastName  String of the last name of the user we want to add
     * @param email     String of the user's email
     * @param age       int of the age of the user
     */
    public void addUserToDatabase(String newFirstName, String newLastName, String newEmail, int newAge) {
        Document newDocument = new Document("First name", newFirstName);
        newDocument.append("Last name", newLastName);
        newDocument.append("Email", newEmail);
        newDocument.append("Age", newAge);
        runTime();
        System.out.println("Database connected...");
        collection.insertOne(newDocument);
        System.out.println("Added " + newFirstName + " " + newLastName + " into MongoDB....");
    }

}
