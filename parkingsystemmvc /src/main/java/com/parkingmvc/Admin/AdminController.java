package com.parkingmvc.Admin;

import javax.swing.JOptionPane;
import org.bson.Document;
import com.parkingmvc.Database;

public class AdminController {

    private AdminView adminView;
    private AdminModel adminModel;
    private Database database;

    public AdminController(AdminView adminView, AdminModel adminModel, Database database) {
        this.adminView = adminView;
        this.adminModel = adminModel;
        this.database = database;
    }

    public void initAdminController() {
        adminView.getSaveButton().addActionListener(e -> {
            String parkingAddressName = adminView.getParkingAddressNameTextField().getText();
            if (parkingAddressName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter parking address name.");
                return;
            }
            int parkingLotCapacity = Integer.parseInt(adminView.getParkingLotCapacityTextField().getText());
            if (parkingLotCapacity <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter parking lot capacity.");
                return;
            }
            int parkingLotCapacityCurrentlyFilled = Integer.parseInt(adminView.getParkingLotCapacityCurrentlyFilledTextField().getText());
            if (parkingLotCapacityCurrentlyFilled < 0) {
                JOptionPane.showMessageDialog(null, "Please enter parking lot capacity currently filled > 0");
                return;
            }
            if (parkingLotCapacityCurrentlyFilled > parkingLotCapacity) {
                JOptionPane.showMessageDialog(null, "Please enter parking lot capacity currently filled < parking lot capacity");
                return;
            }
            String parkingAddressLocation = adminView.getParkingAddressLocationTextField().getText();
            if (parkingAddressLocation.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter parking address location.");
                return;
            }
            String parkingAddressCity = adminView.getParkingAddressCityTextField().getText();
            if (parkingAddressCity.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter parking address city.");
                return;
            }
            String parkingAddressState = adminView.getParkingAddressStateTextField().getText();
            if (parkingAddressState.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter parking address state.");
                return;
            }
            String parkingAddressZipCode = adminView.getParkingAddressZipTextField().getText();
            if (parkingAddressZipCode.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter parking address zip code.");
                return;
            }
            String parkingAddressCountry = adminView.getParkingAddressCountryTextField().getText();
            if (parkingAddressCountry.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter parking address country.");
                return;
            }
            String parkingAddressPhone = adminView.getParkingAddressPhoneTextField().getText();
            if (parkingAddressPhone.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter parking address phone.");
                return;
            }
            if (parkingAddressPhone.length() != 10) {
                JOptionPane.showMessageDialog(null, "Please enter valid phone number.");
                return;
            }
            double parkingAddressLatitude = Double.parseDouble(adminView.getParkingAddressLatitudeTextField().getText());
            if (parkingAddressLatitude < -90 || parkingAddressLatitude > 90) {
                JOptionPane.showMessageDialog(null, "Please enter valid latitude.");
                return;
            }
            double parkingAddressLongitude = Double.parseDouble(adminView.getParkingAddressLongitudeTextField().getText());
            if (parkingAddressLongitude < -180 || parkingAddressLongitude > 180) {
                JOptionPane.showMessageDialog(null, "Please enter valid longitude.");
                return;
            }

            adminModel.setParkingAddressName(parkingAddressName);
            adminModel.setParkingLotCapacity(parkingLotCapacity);
            adminModel.setParkingLotCapacityCurrentlyFilled(parkingLotCapacityCurrentlyFilled);
            adminModel.setParkingAddressLocation(parkingAddressLocation);
            adminModel.setParkingAddressCity(parkingAddressCity);
            adminModel.setParkingAddressState(parkingAddressState);
            adminModel.setParkingAddressZip(parkingAddressZipCode);
            adminModel.setParkingAddressCountry(parkingAddressCountry);
            adminModel.setParkingAddressPhone(parkingAddressPhone);
            adminModel.setParkingAddressLatitude(parkingAddressLatitude);
            adminModel.setParkingAddressLongitude(parkingAddressLongitude);

            Document parkingAddressDocument = new Document();
            parkingAddressDocument.append("parkingAddressName", parkingAddressName);
            parkingAddressDocument.append("parkingLotCapacity", parkingLotCapacity);
            parkingAddressDocument.append("parkingLotCapacityCurrentlyFilled", parkingLotCapacityCurrentlyFilled);
            parkingAddressDocument.append("parkingAddressLocation", parkingAddressLocation);
            parkingAddressDocument.append("parkingAddressCity", parkingAddressCity);
            parkingAddressDocument.append("parkingAddressState", parkingAddressState);
            parkingAddressDocument.append("parkingAddressZipCode", parkingAddressZipCode);
            parkingAddressDocument.append("parkingAddressCountry", parkingAddressCountry);
            parkingAddressDocument.append("parkingAddressPhone", parkingAddressPhone);
            parkingAddressDocument.append("parkingAddressLatitude", parkingAddressLatitude);
            parkingAddressDocument.append("parkingAddressLongitude", parkingAddressLongitude);

            database.insertParkingLotDocument(parkingAddressDocument);

            JOptionPane.showMessageDialog(null, "Parking address added successfully.");

            adminView.getParkingAddressNameTextField().setText("");
            adminView.getParkingLotCapacityTextField().setText("");
            adminView.getParkingLotCapacityCurrentlyFilledTextField().setText("");
            adminView.getParkingAddressLocationTextField().setText("");
            adminView.getParkingAddressCityTextField().setText("");
            adminView.getParkingAddressStateTextField().setText("");
            adminView.getParkingAddressZipTextField().setText("");
            adminView.getParkingAddressCountryTextField().setText("");
            adminView.getParkingAddressPhoneTextField().setText("");
            adminView.getParkingAddressLatitudeTextField().setText("");
            adminView.getParkingAddressLongitudeTextField().setText("");

            adminView.disposeFrameAdmin();


        });

        adminView.getResetButton().addActionListener(e -> {
            adminView.getParkingAddressNameTextField().setText("");
            adminView.getParkingLotCapacityTextField().setText("");
            adminView.getParkingLotCapacityCurrentlyFilledTextField().setText("");
            adminView.getParkingAddressLocationTextField().setText("");
            adminView.getParkingAddressCityTextField().setText("");
            adminView.getParkingAddressStateTextField().setText("");
            adminView.getParkingAddressZipTextField().setText("");
            adminView.getParkingAddressCountryTextField().setText("");
            adminView.getParkingAddressPhoneTextField().setText("");
            adminView.getParkingAddressLatitudeTextField().setText("");
            adminView.getParkingAddressLongitudeTextField().setText("");
        });

        adminView.getCancelButton().addActionListener(e -> {
            System.exit(0);
        });

        adminView.getDeleteButton().addActionListener(e -> {
            String parkingAddressName = adminView.getParkingAddressNameTextField().getText();
            if (parkingAddressName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter parking address name.");
                return;
            }
            adminModel.setParkingAddressName(parkingAddressName);
            int successValue = database.deleteParkingLotDocument(parkingAddressName);
            if (successValue == 1) {
                JOptionPane.showMessageDialog(null, "Parking address deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Parking address not found.");
            }
            adminView.getParkingAddressNameTextField().setText("");
            adminView.getParkingLotCapacityTextField().setText("");
            adminView.getParkingLotCapacityCurrentlyFilledTextField().setText("");
            adminView.getParkingAddressLocationTextField().setText("");
            adminView.getParkingAddressCityTextField().setText("");
            adminView.getParkingAddressStateTextField().setText("");
            adminView.getParkingAddressZipTextField().setText("");
            adminView.getParkingAddressCountryTextField().setText("");
            adminView.getParkingAddressPhoneTextField().setText("");
            adminView.getParkingAddressLatitudeTextField().setText("");
            adminView.getParkingAddressLongitudeTextField().setText("");
        });
    }
}

