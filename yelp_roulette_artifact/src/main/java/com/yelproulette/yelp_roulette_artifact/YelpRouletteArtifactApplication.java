package com.yelproulette.yelp_roulette_artifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

@SpringBootApplication
public class YelpRouletteArtifactApplication {
	private static MongoClient mongoClient;
	private static DB database;
	private static DBCollection test;
	private static MongoCollection collection;
	private static DBCursor cursor;

	MongoDBUser mongoDBUser = new MongoDBUser("", "", "", 0);
	MongoDBService mDBS = new MongoDBService();

	public static void main(String[] args) {
		SpringApplication.run(YelpRouletteArtifactApplication.class, args);

	}

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
