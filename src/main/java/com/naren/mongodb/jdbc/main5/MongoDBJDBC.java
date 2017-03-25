package com.naren.mongodb.jdbc.main5;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDBJDBC {
	public static void main(String args[]) {
		try {

			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient("localhost", 27017);

			// Now connect to your databases
			DB db = mongoClient.getDB("test");
			System.out.println("Connect to database successfully");

			/*
			 * boolean auth = db.authenticate(myUserName, myPassword);
			 * System.out.println("Authentication: "+auth);
			 */

			DBCollection coll = db.createCollection("mycol", null);
			System.out.println("Collection created successfully");
			
	        BasicDBObject doc = new BasicDBObject("title", "MongoDB").
	                 append("description", "database").
	                 append("likes", 100).
	                 append("url", "http://www.tutorialspoint.com/mongodb/").
	                 append("by", "tutorials point");
	     				
	              coll.insert(doc);
	        System.out.println("Document inserted successfully");
	        
	        DBCollection coll1 = db.getCollection("mycol");
	        System.out.println("Collection mycol selected successfully");
				
	         DBCursor cursor = coll1.find();
	         int i = 1;
				
	         while (cursor.hasNext()) { 
	            System.out.println("Inserted Document: "+i); 
	            System.out.println(cursor.next()); 
	            i++;
	         }
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}
}
