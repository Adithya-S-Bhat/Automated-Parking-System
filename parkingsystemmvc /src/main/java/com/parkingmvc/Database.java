package com.parkingmvc;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Database {
    
    private String connectionString; // "mongodb://localhost:27017"
    private String databaseName;
    private String collectionName;

    public Database(String connectionString, String databaseName, String collectionName) {
        this.connectionString = connectionString;
        this.databaseName = databaseName;
        this.collectionName = collectionName;
    }

    public String getConnectionString() {
        return connectionString;
    }
    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
    public String getDatabaseName() {
        return databaseName;
    }
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    public String getCollectionName() {
        return collectionName;
    }
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void insertUser(Document user) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(user);
        mongoClient.close();
    }

    public boolean getUserID(String userID) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document user = collection.find(new Document("UserID", userID)).first();
        if (user != null) {
            mongoClient.close();
            return true;
        }
        mongoClient.close();
        return false;
    }

    public Document getUser(String userID) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document user = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return user;
    }

    public boolean verifyPassword(String password) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document user = collection.find(new Document("Password", password)).first();
        if (user != null) {
            mongoClient.close();
            return true;
        }
        mongoClient.close();
        return false;
    }

    public void insertParkingLotDocument(Document parkingLotDocument) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(parkingLotDocument);
        mongoClient.close();
    }

    public int deleteParkingLotDocument(String parkingAddressName) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        // First find if the parking lot exists
        Document parkingLotDocument = collection.find(new Document("parkingAddressName", parkingAddressName)).first();
        if (parkingLotDocument != null) {
            collection.deleteOne(parkingLotDocument);
            mongoClient.close();
            return 1;
        }
        mongoClient.close();
        return 0;
    }

    public void insertLoggedInUser(String userID) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection("loggedinusers");
        collection.insertOne(new Document("UserID", userID));
        collection.updateOne(new Document("UserID", userID), new Document("$set", new Document("loggedin", true)));
        mongoClient.close();
    }

    public void insertStartTime(String userID, String startTime) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection("loggedinusers");
        collection.updateOne(new Document("UserID", userID), new Document("$set", new Document("startTime", startTime)));
        collection.updateOne(new Document("UserID", userID), new Document("$set", new Document("loggedin", false)));
        mongoClient.close();
    }

    public void insertLatandLong(String userID, String latitude, String longitude) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection("loggedinusers");
        collection.updateOne(new Document("UserID", userID), new Document("$set", new Document("latitude", latitude)));
        collection.updateOne(new Document("UserID", userID), new Document("$set", new Document("longitude", longitude)));
        mongoClient.close();
    }

    public String getLatitude(String userID) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection("loggedinusers");
        Document user = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return user.getString("latitude");
    }

    public String getLongitude(String userID) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection("loggedinusers");
        Document user = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return user.getString("longitude");
    }

    public List<String> getAllLatitudeAndLongitude() {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection("admin");
        List<String> latitudesAndLongitudes = new ArrayList<String>();
        for (Document parkingLotDocument : collection.find()) {
            String lat = String.valueOf(parkingLotDocument.getDouble("parkingAddressLatitude"));
            String longi = String.valueOf(parkingLotDocument.getDouble("parkingAddressLongitude"));
            latitudesAndLongitudes.add(lat + " " + longi);
        }
        mongoClient.close();
        return latitudesAndLongitudes;
    }

    public String getParkingName(String latitude, String longitude) {
        double lat = Double.parseDouble(latitude);
        double longi = Double.parseDouble(longitude);
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("parkingAddressLatitude", lat).append("parkingAddressLongitude", longi)).first();
        mongoClient.close();
        return parkingLotDocument.getString("parkingAddressName");
    }

    public String getParkingLocation(String latitude, String longitude) {
        double lat = Double.parseDouble(latitude);
        double longi = Double.parseDouble(longitude);
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("parkingAddressLatitude", lat).append("parkingAddressLongitude", longi)).first();
        mongoClient.close();
        return parkingLotDocument.getString("parkingAddressLocation");
    }

    public String getParkingCity(String latitude, String longitude) {
        double lat = Double.parseDouble(latitude);
        double longi = Double.parseDouble(longitude);
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("parkingAddressLatitude", lat).append("parkingAddressLongitude", longi)).first();
        mongoClient.close();
        return parkingLotDocument.getString("parkingAddressCity");
    }

    public String getParkingState(String latitude, String longitude) {
        double lat = Double.parseDouble(latitude);
        double longi = Double.parseDouble(longitude);
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("parkingAddressLatitude", lat).append("parkingAddressLongitude", longi)).first();
        mongoClient.close();
        return parkingLotDocument.getString("parkingAddressState");
    }

    public String getParkingZip(String latitude, String longitude) {
        double lat = Double.parseDouble(latitude);
        double longi = Double.parseDouble(longitude);
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("parkingAddressLatitude", lat).append("parkingAddressLongitude", longi)).first();
        mongoClient.close();
        return parkingLotDocument.getString("parkingAddressZipCode");
    }

    public String getParkingCountry(String latitude, String longitude) {
        double lat = Double.parseDouble(latitude);
        double longi = Double.parseDouble(longitude);
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("parkingAddressLatitude", lat).append("parkingAddressLongitude", longi)).first();
        mongoClient.close();
        return parkingLotDocument.getString("parkingAddressCountry");
    }

    public String getParkingPhoneNumber(String latitude, String longitude) {
        double lat = Double.parseDouble(latitude);
        double longi = Double.parseDouble(longitude);
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("parkingAddressLatitude", lat).append("parkingAddressLongitude", longi)).first();
        mongoClient.close();
        return parkingLotDocument.getString("parkingAddressPhone");
    }

    public int getParkingCapacity(String latitude, String longitude) {
        double lat = Double.parseDouble(latitude);
        double longi = Double.parseDouble(longitude);
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("parkingAddressLatitude", lat).append("parkingAddressLongitude", longi)).first();
        mongoClient.close();
        return parkingLotDocument.getInteger("parkingLotCapacity");
    }

    public int getParkingAvailableCapacity(String latitude, String longitude) {
        double lat = Double.parseDouble(latitude);
        double longi = Double.parseDouble(longitude);
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("parkingAddressLatitude", lat).append("parkingAddressLongitude", longi)).first();
        mongoClient.close();
        return parkingLotDocument.getInteger("parkingLotCapacityCurrentlyFilled");
    }

    public int increaseParkingLotCurrentlyFilled(String parkingName) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("parkingAddressName", parkingName)).first();
        int parkingLotCapacity = parkingLotDocument.getInteger("parkingLotCapacity");
        int parkingLotCapacityCurrentlyFilled = parkingLotDocument.getInteger("parkingLotCapacityCurrentlyFilled");
        int newParkingLotCapacityCurrentlyFilled = parkingLotCapacityCurrentlyFilled + 1;
        if (newParkingLotCapacityCurrentlyFilled > parkingLotCapacity) {
            mongoClient.close();
            return -1;
        }
        else{
            collection.updateOne(new Document("parkingAddressName", parkingName), new Document("$set", new Document("parkingLotCapacityCurrentlyFilled", newParkingLotCapacityCurrentlyFilled)));
            mongoClient.close();
            return 1;
        }
    }

    public void insertParkingLotSelected(String userID, String parkingLotInfo){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("UserID", userID)).first();
        if(parkingLotDocument == null){
            collection.insertOne(new Document("UserID", userID).append("parkingLotInfo", parkingLotInfo));
        }
        else{
            collection.updateOne(new Document("UserID", userID), new Document("$set", new Document("parkingLotSelected", parkingLotInfo)));
        }
        mongoClient.close();
    }

    public String getParkingLotSelected(String userID){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return parkingLotDocument.getString("parkingLotSelected");
    
    }

    public Document getLoggedInUser(String userID){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return parkingLotDocument;
    }

    public void insertParkingSlotNumberAllocated(String userID, String parkingSlotNumberAllocated){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        int parkingSlotNumberAllocatedInt = Integer.parseInt(parkingSlotNumberAllocated);
        int newParkingSlotNumberAllocated = parkingSlotNumberAllocatedInt + 1;
        // Convert to string
        String newParkingSlotNumberAllocatedString = Integer.toString(newParkingSlotNumberAllocated);
        collection.updateOne(new Document("UserID", userID), new Document("$set", new Document("parkingSlotNumberAllocated", newParkingSlotNumberAllocatedString)));
        mongoClient.close();
    }     

    public void setLoginWelcomeBackStatus(String userID, boolean status){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.updateOne(new Document("UserID", userID), new Document("$set", new Document("loggedin", status)));
        mongoClient.close();
    }

    public String getUserFullName(String userID){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return parkingLotDocument.getString("FirstName") + " " + parkingLotDocument.getString("LastName"); 
    }

    public String getUserCarModel(String userID){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return parkingLotDocument.getString("CarModel"); 
    }

    public String getUserCarNumber(String userID){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return parkingLotDocument.getString("CarPlateNumber"); 
    }

    public String getUserCarColor(String userID){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return parkingLotDocument.getString("CarColor"); 
    }

    public String getLoggedInUserParkedSlotNumber(String userID){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return parkingLotDocument.getString("parkingSlotNumberAllocated"); 
    }

    public void insertEndTime(String userID, String endTime){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.updateOne(new Document("UserID", userID), new Document("$set", new Document("endTime", endTime)));
        mongoClient.close();
    }

    public String getLoggedInUserStartTime(String userID){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return parkingLotDocument.getString("startTime"); 
    }

    public String getLoggedInUserEndTime(String userID){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return parkingLotDocument.getString("endTime"); 
    }

    public void insertTotalTimeParked(String userID, Double totalTimeParked){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.updateOne(new Document("UserID", userID), new Document("$set", new Document("totalTimeParked", totalTimeParked)));
        mongoClient.close();
    }

    public double getLoggedInUserTotalTimeParked(String userID){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("UserID", userID)).first();
        mongoClient.close();
        return parkingLotDocument.getDouble("totalTimeParked"); 
    }

    public void decreaseParkingLotCurrentlyFilled(String parkingCenterName){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document parkingLotDocument = collection.find(new Document("parkingAddressName", parkingCenterName)).first();
        int currentFilled = parkingLotDocument.getInteger("parkingLotCapacityCurrentlyFilled");
        collection.updateOne(new Document("parkingAddressName", parkingCenterName), new Document("$set", new Document("parkingLotCapacityCurrentlyFilled", currentFilled-1)));
        mongoClient.close();
    }

    public void deleteloggedinuser(String userID){
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteOne(new Document("UserID", userID));
        mongoClient.close();
    }
}
