package com.parkingmvc.UserLogin;

public class LoginModel {
    
    // Make userID static so that it can be accessed by all classes
    public static String userID;

    // public LoginModel(String userID) {
    //     this.userID = userID;
    // }

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        LoginModel.userID = userID;
    }

}
