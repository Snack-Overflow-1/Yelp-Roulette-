package com.yelproulette.yelp_roulette_artifact;

import com.mongodb.*;
import java.net.UnknownHostException;

public class MongoDB {

    public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection test;

    public static void main(String[] args) {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB("Database1");
        test = database.getCollection("test");

        TestObj testObj = new TestObj();
        testObj.setMemberID("abcd");
        testObj.setTimer(1);
        testObj.setX(100);

        test.insert(convert(testObj));

        DBObject query = new BasicDBObject("Timer:", 1);
        DBCursor cursor = test.find(query);
        System.out.println(cursor.one());
    }

    public static DBObject convert(TestObj testObj) {
        return new BasicDBObject("x:", testObj.getX()).append("Timer:", testObj.getTimer()).append("memberID:",
                testObj.getMemberID());
    }

}
