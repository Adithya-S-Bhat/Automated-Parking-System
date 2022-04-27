package com.parkingmvc.UserRegistration;

public class RegistrationModel {
    
    private String firstName;
    private String lastName;
    private String userID;
    private String password;
    private String confirmPassword;
    private String email;
    private String phoneNumber;
    private String driversLicense;
    private String carModel;
    private String carColor;
    private String carPlateNumber;

    public RegistrationModel(String firstName, String lastName, String userID, String password, String confirmPassword, String email, String phoneNumber, String driversLicense, String carModel, String carColor, String carPlateNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.driversLicense = driversLicense;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carPlateNumber = carPlateNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getDriversLicense() {
        return driversLicense;
    }
    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public String getCarColor() {
        return carColor;
    }
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    public String getCarPlateNumber() {
        return carPlateNumber;
    }
    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }
}
