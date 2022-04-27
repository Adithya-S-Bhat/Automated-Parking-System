package com.parkingmvc.UserRegistration;


import javax.swing.JOptionPane;
import org.bson.Document;
import com.parkingmvc.Database;

public class RegistrationController {

    private RegistrationView registrationView;
    private RegistrationModel registrationModel;
    private Database database;

    public RegistrationController(RegistrationView registrationView, RegistrationModel registrationModel, Database database) {
        this.registrationView = registrationView;
        this.registrationModel = registrationModel;
        this.database = database;
    }

    public void initRegistrationController(){
        registrationView.getRegisterButton().addActionListener(e -> {
            String firstName = registrationView.getFirstnameTextField().getText();
            if (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your first name.");
                return;
            }
            String lastName = registrationView.getLastnameTextField().getText();
            if (lastName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your last name.");
                return;
            }
            String userID = registrationView.getUserIDTextField().getText();
            if (userID.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your user ID.");
                return;
            }
            if (database.getUserID(userID) == true) {
                JOptionPane.showMessageDialog(null, "User ID already exists.");
                return;
            }
            String password = registrationView.getPasswordTextField().getText();
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your password.");
                return;
            }
            String confirmPassword = registrationView.getConfirmPasswordTextField().getText();
            if (confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please confirm your password.");
                return;
            }
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match.");
                return;
            }
            String email = registrationView.getEmailTextField().getText();
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your email.");
                return;
            }
            String phoneNumber = registrationView.getPhoneTextField().getText();
            if (phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your phone number.");
                return;
            }
            if (phoneNumber.length() != 10) {
                JOptionPane.showMessageDialog(null, "Please enter a valid phone number.");
                return;
            }
            String driversLicense = registrationView.getDriversLicenseTextField().getText();
            if (driversLicense.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your drivers license.");
                return;
            }
            String carModel = registrationView.getCarModelTextField().getText();
            if (carModel.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your car model.");
                return;
            }
            String carColor = registrationView.getCarColorTextField().getText();
            if (carColor.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your car color.");
                return;
            }
            String carPlateNumber = registrationView.getCarLicensePlateTextField().getText();
            if (carPlateNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your car plate number.");
                return;
            }
            registrationModel.setFirstName(firstName);
            registrationModel.setLastName(lastName);
            registrationModel.setUserID(userID);
            registrationModel.setPassword(password);
            registrationModel.setConfirmPassword(confirmPassword);
            registrationModel.setEmail(email);
            registrationModel.setPhoneNumber(phoneNumber);
            registrationModel.setDriversLicense(driversLicense);
            registrationModel.setCarModel(carModel);
            registrationModel.setCarColor(carColor);
            registrationModel.setCarPlateNumber(carPlateNumber);

            Document User = new Document();
            User.append("FirstName", registrationModel.getFirstName());
            User.append("LastName", registrationModel.getLastName());
            User.append("UserID", registrationModel.getUserID());
            User.append("Password", registrationModel.getPassword());
            User.append("Email", registrationModel.getEmail());
            User.append("PhoneNumber", registrationModel.getPhoneNumber());
            User.append("DriversLicense", registrationModel.getDriversLicense());
            User.append("CarModel", registrationModel.getCarModel());
            User.append("CarColor", registrationModel.getCarColor());
            User.append("CarPlateNumber", registrationModel.getCarPlateNumber());
            database.insertUser(User);

            registrationView.getFirstnameTextField().setText("");
            registrationView.getLastnameTextField().setText("");
            registrationView.getUserIDTextField().setText("");
            registrationView.getPasswordTextField().setText("");
            registrationView.getConfirmPasswordTextField().setText("");
            registrationView.getEmailTextField().setText("");
            registrationView.getPhoneTextField().setText("");
            registrationView.getDriversLicenseTextField().setText("");
            registrationView.getCarModelTextField().setText("");
            registrationView.getCarColorTextField().setText("");
            registrationView.getCarLicensePlateTextField().setText("");

            JOptionPane.showMessageDialog(null, "Registration successful.");

            registrationView.disposeFrame();
        });

        registrationView.getResetButton().addActionListener(e -> {
            registrationView.getFirstnameTextField().setText("");
            registrationView.getLastnameTextField().setText("");
            registrationView.getUserIDTextField().setText("");
            registrationView.getPasswordTextField().setText("");
            registrationView.getConfirmPasswordTextField().setText("");
            registrationView.getEmailTextField().setText("");
            registrationView.getPhoneTextField().setText("");
            registrationView.getDriversLicenseTextField().setText("");
            registrationView.getCarModelTextField().setText("");
            registrationView.getCarColorTextField().setText("");
            registrationView.getCarLicensePlateTextField().setText("");
        });

        registrationView.getCancelButton().addActionListener(e -> {
            System.exit(0);
        });

        registrationView.getLoginButton().addActionListener(e -> {
            registrationView.disposeFrame();
        });
    }
}
