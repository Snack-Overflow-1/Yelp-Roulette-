package com.yelproulette.yelp_roulette_artifact;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
@RestController
@CrossOrigin
@ServletComponentScan
@RequestMapping("/api")

public class DatabaseController {
    private static MongoClient mongoClient;
    private static DB database;
    private static DBCollection test;
    private static MongoCollection collection;
    private static DBCursor cursor;

    MongoDBUser mongoDBUser = new MongoDBUser("", "", "", 0);
    MongoDBService mDBS = new MongoDBService();

    @PostMapping("/login")
    public void postInput(@RequestBody MongoDBUser mongoDBUser) {
        this.mongoDBUser.setFirstName(mongoDBUser.getFirstName());
        this.mongoDBUser.setLastName(mongoDBUser.getLastName());
        this.mongoDBUser.setEmail(mongoDBUser.getEmail());
        this.mongoDBUser.setAge(mongoDBUser.getAge());

        mDBS.addUserToDatabase(mongoDBUser.getFirstName(), mongoDBUser.getLastName(), mongoDBUser.getEmail(),
                mongoDBUser.getAge());
    }

    @GetMapping("/test")
    public String string() {
        return "Testing works....";
    }
}
