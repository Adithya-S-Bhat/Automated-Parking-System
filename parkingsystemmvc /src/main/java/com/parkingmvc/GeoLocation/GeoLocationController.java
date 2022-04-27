package com.parkingmvc.GeoLocation;

import javax.lang.model.util.ElementScanner14;
import javax.swing.JOptionPane;
import org.bson.Document;
import com.parkingmvc.Database;

import com.parkingmvc.UserLogin.LoginModel;

public class GeoLocationController {

    private GeoLocationView geoLocationView;
    private GeoLocationModel geoLocationModel;

    public GeoLocationController(GeoLocationView geoLocationView, GeoLocationModel geoLocationModel) {
        this.geoLocationView = geoLocationView;
        this.geoLocationModel = geoLocationModel;
    }

    public void initGeoLocationController(){
        geoLocationView.getBtnAccept().addActionListener(e -> {
            try{
            geoLocationModel.getGeoLocation();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(null, "Your Location is : " + "\n"+ "Latitude: " + geoLocationModel.getLatitude() + "\n" + "Longitude: " + geoLocationModel.getLongitude() + "\nAddress: " + geoLocationModel.getAddress());
            Database database2 = new Database("mongodb://localhost:27017", "parkingSystem", "loggedinusers");
            String userID = LoginModel.getUserID();
            database2.insertLatandLong(userID, geoLocationModel.getLatitude(), geoLocationModel.getLongitude());
            geoLocationView.disposeGeoLocationPermissionFrame();
            return; 
        });

        geoLocationView.getBtnReject().addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Cannot proceed without permission.");
            return;
        });
    }
    
}
