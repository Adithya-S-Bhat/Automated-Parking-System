package com.parkingmvc.GeoLocation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeoLocationModel {

    private String Latitude;
    private String Longitude;
    private String Address;
    private String address_string = "";
    private String error_string = "";

    public void getGeoLocation() throws IOException, InterruptedException {
        //String command = "python /Users/abhishek-aditya-bs/Desktop/ParkingSystemMVC/parkingsystemmvc/src/main/java/com/parkingmvc/GeoLocation/GeoLocater.py";
        String command = "python C:\\Users\\adith\\Downloads\\ParkingSystemMVC\\parkingsystemmvc\\src\\main\\java\\com\\parkingmvc\\GeoLocation\\GeoLocater.py";
        Process p = Runtime.getRuntime().exec(command);
        p.waitFor();
        BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String line;
        while ((line = bri.readLine()) != null) {
            address_string = address_string.concat(line);
            address_string = address_string.concat("\n");
        }
        bri.close();
        while ((line = bre.readLine()) != null) {
            error_string = error_string.concat(line);
            error_string = error_string.concat("\n");
        }
        bre.close();
        p.waitFor();
        p.destroy();

        String[] address_array = address_string.split("\n");
        this.Latitude = address_array[0];
        this.Longitude = address_array[1];
        this.Address = address_array[2];
    }
    public String getLatitude() {
        return Latitude;
    }
    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }
    public String getLongitude() {
        return Longitude;
    }
    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }
    public String getError_string() {
        return error_string;
    }
    public void setError_string(String error_string) {
        this.error_string = error_string;
    }
    public String getAddress_string() {
        return address_string;
    }
    public void setAddress_string(String address_string) {
        this.address_string = address_string;
    }
}
