package com.parkingmvc.Dashboard;

import javax.swing.JOptionPane;
import org.bson.Document;
import com.parkingmvc.Database;
import com.parkingmvc.UserLogin.LoginModel;

public class DashboardController {

    private DashboardView dashboardView;
    private DashboardModel dashboardModel;
    private Database database_loggedinusers;
    private Database database_admin;

    public DashboardController(DashboardView dashboardView, DashboardModel dashboardModel, Database database_loggedinusers, Database database_admin) {
        this.dashboardView = dashboardView;
        this.dashboardModel = dashboardModel;
        this.database_loggedinusers = database_loggedinusers;
        this.database_admin = database_admin;
    }

    public void initDashboardController() {
        dashboardView.getProceedButton().addActionListener(e -> {
            // Store which of the five radio buttons is selected
            if (dashboardView.getParkingLotOneRadioButton().isSelected()) {
                dashboardModel.setParkingLotSelected(dashboardView.getParkingLotInfoLabel1().getText());
                database_loggedinusers.insertParkingLotSelected(LoginModel.getUserID(),dashboardView.getParkingLotInfoLabel1().getText());
                database_loggedinusers.insertParkingSlotNumberAllocated(LoginModel.getUserID(), dashboardView.getparkingLotAvailableSpotsLabel1().getText());
                String parkingLotName = dashboardView.getParkingLotInfoLabel1().getText().split("\n")[0];
                int sucessValue = database_admin.increaseParkingLotCurrentlyFilled(parkingLotName);
                if (sucessValue == 1) {
                    JOptionPane.showMessageDialog(null, "You have selected parking lot " + parkingLotName);
                } else {
                    JOptionPane.showMessageDialog(null, "Parking lot " + parkingLotName + " is currently full");
                }
                dashboardView.disposeFrameDashboard();
            } else if (dashboardView.getParkingLotTwoRadioButton().isSelected()) {
                dashboardModel.setParkingLotSelected(dashboardView.getParkingLotInfoLabel2().getText());
                database_loggedinusers.insertParkingLotSelected(LoginModel.getUserID(),dashboardView.getParkingLotInfoLabel2().getText());
                database_loggedinusers.insertParkingSlotNumberAllocated(LoginModel.getUserID(), dashboardView.getparkingLotAvailableSpotsLabel2().getText());
                String parkingLotName = dashboardView.getParkingLotInfoLabel2().getText().split("\n")[0];
                int sucessValue = database_admin.increaseParkingLotCurrentlyFilled(parkingLotName);
                if (sucessValue == 1) {
                    JOptionPane.showMessageDialog(null, "You have selected parking lot " + parkingLotName);
                } else {
                    JOptionPane.showMessageDialog(null, "Parking lot " + parkingLotName + " is currently full");
                }
                dashboardView.disposeFrameDashboard();
            } else if (dashboardView.getParkingLotThreeRadioButton().isSelected()) {
                dashboardModel.setParkingLotSelected(dashboardView.getParkingLotInfoLabel3().getText());
                database_loggedinusers.insertParkingLotSelected(LoginModel.getUserID(),dashboardView.getParkingLotInfoLabel3().getText());
                database_loggedinusers.insertParkingSlotNumberAllocated(LoginModel.getUserID(), dashboardView.getparkingLotAvailableSpotsLabel3().getText());
                String parkingLotName = dashboardView.getParkingLotInfoLabel3().getText().split("\n")[0];
                int sucessValue = database_admin.increaseParkingLotCurrentlyFilled(parkingLotName);
                if (sucessValue == 1) {
                    JOptionPane.showMessageDialog(null, "You have selected parking lot " + parkingLotName);
                } else {
                    JOptionPane.showMessageDialog(null, "Parking lot " + parkingLotName + " is currently full");
                }
                dashboardView.disposeFrameDashboard();
            } else if (dashboardView.getParkingLotFourRadioButton().isSelected()) {
                dashboardModel.setParkingLotSelected(dashboardView.getParkingLotInfoLabel4().getText());
                database_loggedinusers.insertParkingLotSelected(LoginModel.getUserID(),dashboardView.getParkingLotInfoLabel4().getText());
                database_loggedinusers.insertParkingSlotNumberAllocated(LoginModel.getUserID(), dashboardView.getparkingLotAvailableSpotsLabel4().getText());
                String parkingLotName = dashboardView.getParkingLotInfoLabel4().getText().split("\n")[0];
                int sucessValue = database_admin.increaseParkingLotCurrentlyFilled(parkingLotName);
                if (sucessValue == 1) {
                    JOptionPane.showMessageDialog(null, "You have selected parking lot " + parkingLotName);
                } else {
                    JOptionPane.showMessageDialog(null, "Parking lot " + parkingLotName + " is currently full");
                }
                dashboardView.disposeFrameDashboard();
            } else if (dashboardView.getParkingLotFiveRadioButton().isSelected()) {
                dashboardModel.setParkingLotSelected(dashboardView.getParkingLotInfoLabel5().getText());
                database_loggedinusers.insertParkingLotSelected(LoginModel.getUserID(),dashboardView.getParkingLotInfoLabel5().getText());
                database_loggedinusers.insertParkingSlotNumberAllocated(LoginModel.getUserID(), dashboardView.getparkingLotAvailableSpotsLabel5().getText());
                String parkingLotName = dashboardView.getParkingLotInfoLabel5().getText().split("\n")[0];
                int sucessValue = database_admin.increaseParkingLotCurrentlyFilled(parkingLotName);
                if (sucessValue == 1) {
                    JOptionPane.showMessageDialog(null, "You have selected parking lot " + parkingLotName);
                } else {
                    JOptionPane.showMessageDialog(null, "Parking lot " + parkingLotName + " is currently full");
                }
                dashboardView.disposeFrameDashboard();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a parking lot");
            }
        });


        dashboardView.getCancelButton().addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "You have cancelled your booking");
            dashboardView.disposeFrameDashboard();
            System.exit(0);
        }); 
    }

}
