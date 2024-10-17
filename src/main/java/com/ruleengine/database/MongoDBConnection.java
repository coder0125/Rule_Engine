package com.ruleengine.database;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

	    private static MongoClient mongoClient;
	    private static MongoDatabase database;

	    static {
	        // Initialize MongoDB client and connect to the database
	        mongoClient = MongoClients.create("mongodb://localhost:27017");
	        database = mongoClient.getDatabase("rule-engine");
	    }

	    public static MongoDatabase getDatabase() {
	        return database;
	    }
	    
	 // Insert user data into the collection
	    public static void insertUserData(String collectionName, Document userData) {
	        MongoCollection<Document> collection = database.getCollection(collectionName);
	        collection.insertOne(userData);
	        System.out.println("User data inserted successfully into collection: " + collectionName);

	    }
	    /////
	  /*  public static void insertUserData(String collectionName, Document userData) {
	        // Get the collection (table) from the database
	        MongoCollection<Document> collection = database.getCollection(collectionName);
	        // Insert the user data into the collection
	        collection.insertOne(userData);
	    }*/
	    
	    
	}

