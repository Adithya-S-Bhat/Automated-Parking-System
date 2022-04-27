package com.parkingmvc.Billing;

import com.parkingmvc.UserLogin.LoginModel;
import com.parkingmvc.Database;
import javax.swing.JOptionPane;
import org.bson.Document;

public class BillingController {

    private BillingView billingView;
    private Database database_loggedinusers;
    private Database database_admin;

    public BillingController(BillingView billingView, Database database_loggedinusers, Database database_admin) {
        this.billingView = billingView;
        this.database_loggedinusers = database_loggedinusers;
        this.database_admin = database_admin;
    }

    public void initBillingController() {
        billingView.getProceedButton().addActionListener(e -> {
            if (billingView.getCredit_card().isSelected()) {
                JOptionPane.showMessageDialog(null, "Please pay at the exit gate. Thank you for using our service.");
                String userID = LoginModel.getUserID();
                String parkingCenterName = database_loggedinusers.getParkingLotSelected(userID).split("\n")[0];
                database_admin.decreaseParkingLotCurrentlyFilled(parkingCenterName);
                database_loggedinusers.deleteloggedinuser(userID);
                billingView.disposeFrameBilling();
            }

            else if (billingView.getCash().isSelected()) {
                JOptionPane.showMessageDialog(null, "Please collect your parking ticket at the exit gate. Thank you for using our service.");
                String userID = LoginModel.getUserID();
                String parkingCenterName = database_loggedinusers.getParkingLotSelected(userID).split("\n")[0];
                database_admin.decreaseParkingLotCurrentlyFilled(parkingCenterName);
                database_loggedinusers.deleteloggedinuser(userID);
                billingView.disposeFrameBilling();
            }

            else if (billingView.getDebit_card().isSelected()) {
                JOptionPane.showMessageDialog(null, "Please pay at the exit gate. Thank you for using our service.");
                String userID = LoginModel.getUserID();
                String parkingCenterName = database_loggedinusers.getParkingLotSelected(userID).split("\n")[0];
                database_admin.decreaseParkingLotCurrentlyFilled(parkingCenterName);
                database_loggedinusers.deleteloggedinuser(userID);
                billingView.disposeFrameBilling();
            }

            else if (billingView.getPaypal().isSelected()) {
                JOptionPane.showMessageDialog(null, "Please pay at the exit gate. Thank you for using our service.");
                String userID = LoginModel.getUserID();
                String parkingCenterName = database_loggedinusers.getParkingLotSelected(userID).split("\n")[0];
                database_admin.decreaseParkingLotCurrentlyFilled(parkingCenterName);
                database_loggedinusers.deleteloggedinuser(userID);
                billingView.disposeFrameBilling();
            }

            else if (billingView.getBitcoin().isSelected()) {
                JOptionPane.showMessageDialog(null, "Please pay at the exit gate. Thank you for using our service.");
                String userID = LoginModel.getUserID();
                String parkingCenterName = database_loggedinusers.getParkingLotSelected(userID).split("\n")[0];
                database_admin.decreaseParkingLotCurrentlyFilled(parkingCenterName);
                database_loggedinusers.deleteloggedinuser(userID);
                billingView.disposeFrameBilling();
            }

            else if (billingView.getUPIAccount().isSelected()) {
                JOptionPane.showMessageDialog(null, "Please pay at the exit gate. Thank you for using our service.");
                String userID = LoginModel.getUserID();
                String parkingCenterName = database_loggedinusers.getParkingLotSelected(userID).split("\n")[0];
                database_admin.decreaseParkingLotCurrentlyFilled(parkingCenterName);
                database_loggedinusers.deleteloggedinuser(userID);
                billingView.disposeFrameBilling();
            }
            
            else if (billingView.getNetbanking().isSelected()) {
                JOptionPane.showMessageDialog(null, "Please pay at the exit gate. Thank you for using our service.");
                String userID = LoginModel.getUserID();
                String parkingCenterName = database_loggedinusers.getParkingLotSelected(userID).split("\n")[0];
                database_admin.decreaseParkingLotCurrentlyFilled(parkingCenterName);
                database_loggedinusers.deleteloggedinuser(userID);
                billingView.disposeFrameBilling();
            }

            else {
                JOptionPane.showMessageDialog(null, "Please select a payment method.");
            }

        });
    }

}
