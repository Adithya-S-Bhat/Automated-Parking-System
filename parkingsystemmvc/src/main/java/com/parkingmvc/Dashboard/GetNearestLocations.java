package com.parkingmvc.Dashboard;

import com.parkingmvc.Database;
import com.parkingmvc.UserLogin.*;

import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.*;

public class GetNearestLocations {
    
    String userID; //= LoginModel.getUserID();
    Database database2; //= new Database("mongodb://localhost:27017", "parkingSystem", "admin");
    static HashMap<Double, String> hashMap = new HashMap<Double, String>();
    static List<Double> listOfDistances = new ArrayList<Double>();
    static List<String> listOfTopFiveParkingNames = new ArrayList<String>();
    static List<String> listOfTopFiveParkingAddressLocations = new ArrayList<String>();
    static List<String> listOfTopFiveParkingCities = new ArrayList<String>();
    static List<String> listOfTopFiveParkingPostalCodes = new ArrayList<String>();
    static List<String> listOfTopFiveParkingStates = new ArrayList<String>();
    static List<String> listOfTopFiveParkingCountry = new ArrayList<String>();
    static List<String> listOfTopFiveParkingLotCapacitiesList = new ArrayList<String>();
    static List<String> listOfTopFiveParkingLotAvailableCapacitiesList = new ArrayList<String>();
    
    public GetNearestLocations(String userID, Database database2) {
        System.out.println("YOOOOOOOOOOOOOO");
        this.userID = userID;
        this.database2 = database2;
    }
    
    public void getTopFiveNearestparking(){
        System.out.println("YOOO from getTopFiveNearestParking");
        double user_latitude = Double.parseDouble(this.database2.getLatitude(this.userID));
        double user_longitude = Double.parseDouble(this.database2.getLongitude(this.userID));
        List<String> allLatLong = this.database2.getAllLatitudeAndLongitude();

        for (String latLong : allLatLong) {
            String[] latLongArray = latLong.split(" ");
            double latitude = Double.parseDouble(latLongArray[0]);
            double longitude = Double.parseDouble(latLongArray[1]);
            double distance = Math.sqrt(Math.pow(latitude - user_latitude, 2) + Math.pow(longitude - user_longitude, 2));
            hashMap.put(distance, latLong);
            listOfDistances.add(distance);
        }

        Collections.sort(listOfDistances);

        for (int i = 0; i < 5; i++) {
            String latLong = hashMap.get(listOfDistances.get(i));
            String[] latLongArray = latLong.split(" ");
            String latitude = latLongArray[0];
            String longitude = latLongArray[1];
            String parkingName = database2.getParkingName(latitude, longitude);
            String parkingAddress = database2.getParkingLocation(latitude, longitude);
            String parkingCity = database2.getParkingCity(latitude, longitude);
            String parkingPostalCode = database2.getParkingZip(latitude, longitude);
            String parkingState = database2.getParkingState(latitude, longitude);
            String parkingCountry = database2.getParkingCountry(latitude, longitude);
            String parkingLotCapacity = String.valueOf(database2.getParkingCapacity(latitude, longitude));
            String parkingLotAvailableCapacity = String.valueOf(database2.getParkingAvailableCapacity(latitude, longitude));
            listOfTopFiveParkingNames.add(parkingName);
            listOfTopFiveParkingAddressLocations.add(parkingAddress);
            listOfTopFiveParkingCities.add(parkingCity);
            listOfTopFiveParkingPostalCodes.add(parkingPostalCode);
            listOfTopFiveParkingStates.add(parkingState);
            listOfTopFiveParkingCountry.add(parkingCountry);
            listOfTopFiveParkingLotCapacitiesList.add(parkingLotCapacity);
            listOfTopFiveParkingLotAvailableCapacitiesList.add(parkingLotAvailableCapacity);
        }

    }
}
