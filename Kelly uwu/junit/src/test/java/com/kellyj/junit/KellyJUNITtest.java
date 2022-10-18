package com.kellyj.junit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static org.junit.Assert.assertTrue;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class KellyJUNITtest {

	@Test
	public void JUNITtest() {
		KellyJUNIT test = new KellyJUNIT(); 
		test.runningtime();
		boolean userFound = test.searchDocumentForUser("name", "Ivan"); 
		assertTrue("User not found", userFound); 

	}
	

}
