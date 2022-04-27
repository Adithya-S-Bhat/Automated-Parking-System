package com.parkingmvc.Admin;

public class AdminModel {

    private String parkingAddressName;
    private int parkingLotCapacity;
    private int parkingLotCapacityCurrentlyFilled;
    private String parkingAddressLocation;
    private String parkingAddressCity;
    private String parkingAddressState;
    private String parkingAddressZip;
    private String parkingAddressCountry;
    private String parkingAddressPhone;
    private double parkingAddressLatitude;
    private double parkingAddressLongitude;

    public AdminModel(String parkingAddressName, int parkingLotCapacity, int parkingLotCapacityCurrentlyFilled, String parkingAddressLocation, String parkingAddressCity, String parkingAddressState, String parkingAddressZip, String parkingAddressCountry, String parkingAddressPhone, double parkingAddressLatitude, double parkingAddressLongitude) {
        this.parkingAddressName = parkingAddressName;
        this.parkingLotCapacity = parkingLotCapacity;
        this.parkingLotCapacityCurrentlyFilled = parkingLotCapacityCurrentlyFilled;
        this.parkingAddressLocation = parkingAddressLocation;
        this.parkingAddressCity = parkingAddressCity;
        this.parkingAddressState = parkingAddressState;
        this.parkingAddressZip = parkingAddressZip;
        this.parkingAddressCountry = parkingAddressCountry;
        this.parkingAddressPhone = parkingAddressPhone;
        this.parkingAddressLatitude = parkingAddressLatitude;
        this.parkingAddressLongitude = parkingAddressLongitude;
    }

    public String getParkingAddressName() {
        return parkingAddressName;
    }
    public void setParkingAddressName(String parkingAddressName) {
        this.parkingAddressName = parkingAddressName;
    }
    public int getParkingLotCapacity() {
        return parkingLotCapacity;
    }
    public void setParkingLotCapacity(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
    }
    public int getParkingLotCapacityCurrentlyFilled() {
        return parkingLotCapacityCurrentlyFilled;
    }
    public void setParkingLotCapacityCurrentlyFilled(int parkingLotCapacityCurrentlyFilled) {
        this.parkingLotCapacityCurrentlyFilled = parkingLotCapacityCurrentlyFilled;
    }

    public String getParkingAddressLocation() {
        return parkingAddressLocation;
    }
    public void setParkingAddressLocation(String parkingAddressLocation) {
        this.parkingAddressLocation = parkingAddressLocation;
    }
    public String getParkingAddressCity() {
        return parkingAddressCity;
    }
    public void setParkingAddressCity(String parkingAddressCity) {
        this.parkingAddressCity = parkingAddressCity;
    }
    public String getParkingAddressState() {
        return parkingAddressState;
    }
    public void setParkingAddressState(String parkingAddressState) {
        this.parkingAddressState = parkingAddressState;
    }
    public String getParkingAddressZip() {
        return parkingAddressZip;
    }
    public void setParkingAddressZip(String parkingAddressZip) {
        this.parkingAddressZip = parkingAddressZip;
    }
    public String getParkingAddressCountry() {
        return parkingAddressCountry;
    }
    public void setParkingAddressCountry(String parkingAddressCountry) {
        this.parkingAddressCountry = parkingAddressCountry;
    }
    public String getParkingAddressPhone() {
        return parkingAddressPhone;
    }
    public void setParkingAddressPhone(String parkingAddressPhone) {
        this.parkingAddressPhone = parkingAddressPhone;
    }
    public double getParkingAddressLatitude() {
        return parkingAddressLatitude;
    }
    public void setParkingAddressLatitude(double parkingAddressLatitude) {
        this.parkingAddressLatitude = parkingAddressLatitude;
    }
    public double getParkingAddressLongitude() {
        return parkingAddressLongitude;
    }
    public void setParkingAddressLongitude(double parkingAddressLongitude) {
        this.parkingAddressLongitude = parkingAddressLongitude;
    }    
}
