package com.parkingmvc.Dashboard;

import com.parkingmvc.Database;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.parkingmvc.UserLogout.*;

import javax.swing.*;

import com.parkingmvc.UserLogin.LoginModel;

public class DashboardView {
    
    private JFrame frame;
    private JPanel panel;

    private JLabel lblHeading;
    private JLabel lblHeading2;

    private JLabel spacing;

    private JLabel parkingLotNumber1;
    private JLabel parkingLotNameLabel1;
    private JLabel parkingLotAddressLabel1;
    private JLabel parkingLotCapacityLabel1;
    private JLabel parkingLotAvailableSpotsLabel1;

    private JLabel parkingLotNumber2;
    private JLabel parkingLotNameLabel2;
    private JLabel parkingLotAddressLabel2;
    private JLabel parkingLotCapacityLabel2;
    private JLabel parkingLotAvailableSpotsLabel2;
    
    private JLabel parkingLotNumber3;
    private JLabel parkingLotNameLabel3;
    private JLabel parkingLotAddressLabel3;
    private JLabel parkingLotCapacityLabel3;
    private JLabel parkingLotAvailableSpotsLabel3;

    private JLabel parkingLotNumber4;
    private JLabel parkingLotNameLabel4;
    private JLabel parkingLotAddressLabel4;
    private JLabel parkingLotCapacityLabel4;
    private JLabel parkingLotAvailableSpotsLabel4;

    private JLabel parkingLotNumber5;
    private JLabel parkingLotNameLabel5;
    private JLabel parkingLotAddressLabel5;
    private JLabel parkingLotCapacityLabel5;
    private JLabel parkingLotAvailableSpotsLabel5;


    private JLabel parkingLotInfoLabel1;
    private JLabel parkingLotInfoLabel2;
    private JLabel parkingLotInfoLabel3;
    private JLabel parkingLotInfoLabel4;
    private JLabel parkingLotInfoLabel5;

    private JRadioButton parkingLotOneRadioButton;
    private JRadioButton parkingLotTwoRadioButton;
    private JRadioButton parkingLotThreeRadioButton;
    private JRadioButton parkingLotFourRadioButton;
    private JRadioButton parkingLotFiveRadioButton;

    private JButton proceedButton;
    private JButton cancelButton;

    public DashboardView(){

        GetNearestLocations getNearestLocations = new GetNearestLocations(LoginModel.getUserID(), new Database("mongodb://localhost:27017", "parkingSystem", "admin"));
        getNearestLocations.getTopFiveNearestparking();

        frame = new JFrame("Parking System");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);


        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        lblHeading = new JLabel("Showing top 5 nearest parking lots", SwingConstants.CENTER);
        lblHeading2 = new JLabel("Select a parking lot to proceed");

        spacing = new JLabel(" ");

        parkingLotNumber1 = new JLabel("Parking Lot 1");
        parkingLotNameLabel1 = new JLabel("Parking Lot Name: " + GetNearestLocations.listOfTopFiveParkingNames.get(0));
        parkingLotAddressLabel1 = new JLabel("Parking Lot Address: " + GetNearestLocations.listOfTopFiveParkingAddressLocations.get(0) + "\n" + GetNearestLocations.listOfTopFiveParkingCities.get(0) + "\n" + GetNearestLocations.listOfTopFiveParkingPostalCodes.get(0) + "\n" + GetNearestLocations.listOfTopFiveParkingStates.get(0) + "\n" + GetNearestLocations.listOfTopFiveParkingCountry.get(0));
        parkingLotCapacityLabel1 = new JLabel("Parking Lot Capacity: " + GetNearestLocations.listOfTopFiveParkingLotCapacitiesList.get(0));
        parkingLotAvailableSpotsLabel1 = new JLabel(GetNearestLocations.listOfTopFiveParkingLotAvailableCapacitiesList.get(0));

        parkingLotNumber2 = new JLabel("Parking Lot 2");
        parkingLotNameLabel2 = new JLabel("Parking Lot Name: " + GetNearestLocations.listOfTopFiveParkingNames.get(1));
        parkingLotAddressLabel2 = new JLabel("Parking Lot Address: " + GetNearestLocations.listOfTopFiveParkingAddressLocations.get(1) + "\n" + GetNearestLocations.listOfTopFiveParkingCities.get(1) + "\n" + GetNearestLocations.listOfTopFiveParkingPostalCodes.get(1) + "\n" + GetNearestLocations.listOfTopFiveParkingStates.get(1) + "\n" + GetNearestLocations.listOfTopFiveParkingCountry.get(1));
        parkingLotCapacityLabel2 = new JLabel("Parking Lot Capacity: " + GetNearestLocations.listOfTopFiveParkingLotCapacitiesList.get(1));
        parkingLotAvailableSpotsLabel2 = new JLabel(GetNearestLocations.listOfTopFiveParkingLotAvailableCapacitiesList.get(1));

        parkingLotNumber3 = new JLabel("Parking Lot 3");
        parkingLotNameLabel3 = new JLabel("Parking Lot Name: " + GetNearestLocations.listOfTopFiveParkingNames.get(2));
        parkingLotAddressLabel3 = new JLabel("Parking Lot Address: " + GetNearestLocations.listOfTopFiveParkingAddressLocations.get(2) + "\n" + GetNearestLocations.listOfTopFiveParkingCities.get(2) + "\n" + GetNearestLocations.listOfTopFiveParkingPostalCodes.get(2) + "\n" + GetNearestLocations.listOfTopFiveParkingStates.get(2) + "\n" + GetNearestLocations.listOfTopFiveParkingCountry.get(2));
        parkingLotCapacityLabel3 = new JLabel("Parking Lot Capacity: " + GetNearestLocations.listOfTopFiveParkingLotCapacitiesList.get(2));
        parkingLotAvailableSpotsLabel3 = new JLabel(GetNearestLocations.listOfTopFiveParkingLotAvailableCapacitiesList.get(2));

        parkingLotNumber4 = new JLabel("Parking Lot 4");
        parkingLotNameLabel4 = new JLabel("Parking Lot Name: " + GetNearestLocations.listOfTopFiveParkingNames.get(3));
        parkingLotAddressLabel4 = new JLabel("Parking Lot Address: " + GetNearestLocations.listOfTopFiveParkingAddressLocations.get(3) + "\n" + GetNearestLocations.listOfTopFiveParkingCities.get(3) + "\n" + GetNearestLocations.listOfTopFiveParkingPostalCodes.get(3) + "\n" + GetNearestLocations.listOfTopFiveParkingStates.get(3) + "\n" + GetNearestLocations.listOfTopFiveParkingCountry.get(3));
        parkingLotCapacityLabel4 = new JLabel("Parking Lot Capacity: " + GetNearestLocations.listOfTopFiveParkingLotCapacitiesList.get(3));
        parkingLotAvailableSpotsLabel4 = new JLabel(GetNearestLocations.listOfTopFiveParkingLotAvailableCapacitiesList.get(3));

        parkingLotNumber5 = new JLabel("Parking Lot 5");
        parkingLotNameLabel5 = new JLabel("Parking Lot Name: " + GetNearestLocations.listOfTopFiveParkingNames.get(4));
        parkingLotAddressLabel5 = new JLabel("Parking Lot Address: " + GetNearestLocations.listOfTopFiveParkingAddressLocations.get(4) + "\n" + GetNearestLocations.listOfTopFiveParkingCities.get(4) + "\n" + GetNearestLocations.listOfTopFiveParkingPostalCodes.get(4) + "\n" + GetNearestLocations.listOfTopFiveParkingStates.get(4) + "\n" + GetNearestLocations.listOfTopFiveParkingCountry.get(4));
        parkingLotCapacityLabel5 = new JLabel("Parking Lot Capacity: " + GetNearestLocations.listOfTopFiveParkingLotCapacitiesList.get(4));
        parkingLotAvailableSpotsLabel5 = new JLabel(GetNearestLocations.listOfTopFiveParkingLotAvailableCapacitiesList.get(4));

        parkingLotInfoLabel1 = new JLabel(GetNearestLocations.listOfTopFiveParkingNames.get(0) + "\n" + GetNearestLocations.listOfTopFiveParkingAddressLocations.get(0) + ", " + GetNearestLocations.listOfTopFiveParkingCities.get(0) + " " + GetNearestLocations.listOfTopFiveParkingPostalCodes.get(0) + ", " + GetNearestLocations.listOfTopFiveParkingStates.get(0) + ", " + GetNearestLocations.listOfTopFiveParkingCountry.get(0) + " | Total Capacity :" + GetNearestLocations.listOfTopFiveParkingLotCapacitiesList.get(0) + " | Currently Filled: " + GetNearestLocations.listOfTopFiveParkingLotAvailableCapacitiesList.get(0));
        parkingLotInfoLabel2 = new JLabel(GetNearestLocations.listOfTopFiveParkingNames.get(1) + "\n" + GetNearestLocations.listOfTopFiveParkingAddressLocations.get(1) + ", " + GetNearestLocations.listOfTopFiveParkingCities.get(1) + " " + GetNearestLocations.listOfTopFiveParkingPostalCodes.get(1) + ", " + GetNearestLocations.listOfTopFiveParkingStates.get(1) + ", " + GetNearestLocations.listOfTopFiveParkingCountry.get(1) + " | Total Capacity :" + GetNearestLocations.listOfTopFiveParkingLotCapacitiesList.get(1) + " | Currently Filled: " + GetNearestLocations.listOfTopFiveParkingLotAvailableCapacitiesList.get(1));
        parkingLotInfoLabel3 = new JLabel(GetNearestLocations.listOfTopFiveParkingNames.get(2) + "\n" + GetNearestLocations.listOfTopFiveParkingAddressLocations.get(2) + ", " + GetNearestLocations.listOfTopFiveParkingCities.get(2) + " " + GetNearestLocations.listOfTopFiveParkingPostalCodes.get(2) + ", " + GetNearestLocations.listOfTopFiveParkingStates.get(2) + ", " + GetNearestLocations.listOfTopFiveParkingCountry.get(2) + " | Total Capacity :" + GetNearestLocations.listOfTopFiveParkingLotCapacitiesList.get(2) + " | Currently Filled: " + GetNearestLocations.listOfTopFiveParkingLotAvailableCapacitiesList.get(2));
        parkingLotInfoLabel4 = new JLabel(GetNearestLocations.listOfTopFiveParkingNames.get(3) + "\n" + GetNearestLocations.listOfTopFiveParkingAddressLocations.get(3) + ", " + GetNearestLocations.listOfTopFiveParkingCities.get(3) + " " + GetNearestLocations.listOfTopFiveParkingPostalCodes.get(3) + ", " + GetNearestLocations.listOfTopFiveParkingStates.get(3) + ", " + GetNearestLocations.listOfTopFiveParkingCountry.get(3) + " | Total Capacity :" + GetNearestLocations.listOfTopFiveParkingLotCapacitiesList.get(3) + " | Currently Filled: " + GetNearestLocations.listOfTopFiveParkingLotAvailableCapacitiesList.get(3));
        parkingLotInfoLabel5 = new JLabel(GetNearestLocations.listOfTopFiveParkingNames.get(4) + "\n" + GetNearestLocations.listOfTopFiveParkingAddressLocations.get(4) + ", " + GetNearestLocations.listOfTopFiveParkingCities.get(4) + " " + GetNearestLocations.listOfTopFiveParkingPostalCodes.get(4) + ", " + GetNearestLocations.listOfTopFiveParkingStates.get(4) + ", " + GetNearestLocations.listOfTopFiveParkingCountry.get(4) + " | Total Capacity :" + GetNearestLocations.listOfTopFiveParkingLotCapacitiesList.get(4) + " | Currently Filled: " + GetNearestLocations.listOfTopFiveParkingLotAvailableCapacitiesList.get(4));

        parkingLotOneRadioButton = new JRadioButton("Parking Lot 1");
        parkingLotTwoRadioButton = new JRadioButton("Parking Lot 2");
        parkingLotThreeRadioButton = new JRadioButton("Parking Lot 3");
        parkingLotFourRadioButton = new JRadioButton("Parking Lot 4");
        parkingLotFiveRadioButton = new JRadioButton("Parking Lot 5");

        proceedButton = new JButton("Proceed");
        cancelButton = new JButton("Cancel");

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblHeading)
                        .addComponent(spacing)
                        .addComponent(lblHeading2)
                        .addComponent(spacing)
                        .addComponent(parkingLotNumber1)
                        .addComponent(parkingLotInfoLabel1)
                        .addComponent(spacing)
                        .addComponent(parkingLotNumber2)
                        .addComponent(parkingLotInfoLabel2)
                        .addComponent(spacing)
                        .addComponent(parkingLotNumber3)
                        .addComponent(parkingLotInfoLabel3)
                        .addComponent(spacing)
                        .addComponent(parkingLotNumber4)
                        .addComponent(parkingLotInfoLabel4)
                        .addComponent(spacing)
                        .addComponent(parkingLotNumber5)
                        .addComponent(parkingLotInfoLabel5)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(spacing)
                                .addComponent(parkingLotOneRadioButton)
                                .addComponent(parkingLotTwoRadioButton)
                                .addComponent(parkingLotThreeRadioButton)
                                .addComponent(parkingLotFourRadioButton)
                                .addComponent(parkingLotFiveRadioButton))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(spacing)
                                .addComponent(proceedButton)
                                .addComponent(cancelButton))
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                    .addComponent(lblHeading)
                    .addComponent(spacing)
                    .addComponent(lblHeading2)
                    .addComponent(spacing)
                    .addComponent(parkingLotNumber1)
                    .addComponent(parkingLotInfoLabel1)
                    .addComponent(spacing)
                    .addComponent(parkingLotNumber2)
                    .addComponent(parkingLotInfoLabel2)
                    .addComponent(spacing)
                    .addComponent(parkingLotNumber3)
                    .addComponent(parkingLotInfoLabel3)
                    .addComponent(spacing)
                    .addComponent(parkingLotNumber4)
                    .addComponent(parkingLotInfoLabel4)
                    .addComponent(spacing)
                    .addComponent(parkingLotNumber5)
                    .addComponent(parkingLotInfoLabel5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(spacing)
                        .addComponent(parkingLotOneRadioButton)
                        .addComponent(parkingLotTwoRadioButton)
                        .addComponent(parkingLotThreeRadioButton)
                        .addComponent(parkingLotFourRadioButton)
                        .addComponent(parkingLotFiveRadioButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(spacing)
                        .addComponent(proceedButton)
                        .addComponent(cancelButton))
        );


        panel.setVisible(true);
        frame.add(panel);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void disposeFrameDashboard() {

        frame.setVisible(false);
        frame.dispose();
        UserLogoutView userLogoutView = new UserLogoutView();
        Database database_loggedinusers = new Database("mongodb://localhost:27017", "parkingSystem", "loggedinusers");
        UserLogoutController userLogoutController = new UserLogoutController(userLogoutView, database_loggedinusers);
        userLogoutController.initUserLogoutController();
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getLblHeading() {
        return lblHeading;
    }

    public void setLblHeading(JLabel lblHeading) {
        this.lblHeading = lblHeading;
    }

    public JLabel getLblHeading2() {
        return lblHeading2;
    }

    public void setLblHeading2(JLabel lblHeading2) {
        this.lblHeading2 = lblHeading2;
    }

    public JLabel getParkingLotInfoLabel1() {
        return parkingLotInfoLabel1;
    }

    public void setParkingLotInfoLabel1(JLabel parkingLotInfoLabel1) {
        this.parkingLotInfoLabel1 = parkingLotInfoLabel1;
    }

    public JLabel getParkingLotInfoLabel2() {
        return parkingLotInfoLabel2;
    }

    public JLabel getparkingLotAvailableSpotsLabel1() {
        return parkingLotAvailableSpotsLabel1;
    }

    public void setparkingLotAvailableSpotsLabel1(JLabel parkingLotAvailableSpotsLabel1) {
        this.parkingLotAvailableSpotsLabel1 = parkingLotAvailableSpotsLabel1;
    }

    public JLabel getparkingLotAvailableSpotsLabel2() {
        return parkingLotAvailableSpotsLabel2;
    }

    public void setparkingLotAvailableSpotsLabel2(JLabel parkingLotAvailableSpotsLabel2) {
        this.parkingLotAvailableSpotsLabel2 = parkingLotAvailableSpotsLabel2;
    }

    public JLabel getparkingLotAvailableSpotsLabel3() {
        return parkingLotAvailableSpotsLabel3;
    }

    public void setparkingLotAvailableSpotsLabel3(JLabel parkingLotAvailableSpotsLabel3) {
        this.parkingLotAvailableSpotsLabel3 = parkingLotAvailableSpotsLabel3;
    }

    public JLabel getparkingLotAvailableSpotsLabel4() {
        return parkingLotAvailableSpotsLabel4;
    }

    public void setparkingLotAvailableSpotsLabel4(JLabel parkingLotAvailableSpotsLabel4) {
        this.parkingLotAvailableSpotsLabel4 = parkingLotAvailableSpotsLabel4;
    }

    public JLabel getparkingLotAvailableSpotsLabel5() {
        return parkingLotAvailableSpotsLabel5;
    }

    public void setparkingLotAvailableSpotsLabel5(JLabel parkingLotAvailableSpotsLabel5) {
        this.parkingLotAvailableSpotsLabel5 = parkingLotAvailableSpotsLabel5;
    }

    public void setParkingLotInfoLabel2(JLabel parkingLotInfoLabel2) {
        this.parkingLotInfoLabel2 = parkingLotInfoLabel2;
    }

    public JLabel getParkingLotInfoLabel3() {
        return parkingLotInfoLabel3;
    }

    public void setParkingLotInfoLabel3(JLabel parkingLotInfoLabel3) {
        this.parkingLotInfoLabel3 = parkingLotInfoLabel3;
    }

    public JLabel getParkingLotInfoLabel4() {
        return parkingLotInfoLabel4;
    }

    public void setParkingLotInfoLabel4(JLabel parkingLotInfoLabel4) {
        this.parkingLotInfoLabel4 = parkingLotInfoLabel4;
    }

    public JLabel getParkingLotInfoLabel5() {
        return parkingLotInfoLabel5;
    }

    public void setParkingLotInfoLabel5(JLabel parkingLotInfoLabel5) {
        this.parkingLotInfoLabel5 = parkingLotInfoLabel5;
    }

    public JRadioButton getParkingLotOneRadioButton() {
        return parkingLotOneRadioButton;
    }

    public void setParkingLotOneRadioButton(JRadioButton parkingLotOneRadioButton) {
        this.parkingLotOneRadioButton = parkingLotOneRadioButton;
    }

    public JRadioButton getParkingLotTwoRadioButton() {
        return parkingLotTwoRadioButton;
    }

    public void setParkingLotTwoRadioButton(JRadioButton parkingLotTwoRadioButton) {
        this.parkingLotTwoRadioButton = parkingLotTwoRadioButton;
    }

    public JRadioButton getParkingLotThreeRadioButton() {
        return parkingLotThreeRadioButton;
    }

    public void setParkingLotThreeRadioButton(JRadioButton parkingLotThreeRadioButton) {
        this.parkingLotThreeRadioButton = parkingLotThreeRadioButton;
    }

    public JRadioButton getParkingLotFourRadioButton() {
        return parkingLotFourRadioButton;
    }

    public void setParkingLotFourRadioButton(JRadioButton parkingLotFourRadioButton) {
        this.parkingLotFourRadioButton = parkingLotFourRadioButton;
    }

    public JRadioButton getParkingLotFiveRadioButton() {
        return parkingLotFiveRadioButton;
    }

    public void setParkingLotFiveRadioButton(JRadioButton parkingLotFiveRadioButton) {
        this.parkingLotFiveRadioButton = parkingLotFiveRadioButton;
    }

    public JButton getProceedButton() {
        return proceedButton;
    }

    public void setProceedButton(JButton proceedButton) {
        this.proceedButton = proceedButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

}
