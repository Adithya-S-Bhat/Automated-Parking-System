package com.parkingmvc.UserRegistration;

import com.parkingmvc.UserLogin.LoginController;
import com.parkingmvc.UserLogin.LoginModel;
import com.parkingmvc.UserLogin.LoginView;
import com.parkingmvc.Database;
import java.awt.BorderLayout;
import javax.swing.*;

public class RegistrationView {

    private JFrame frame;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel userIDLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JLabel driversLicenseLabel;
    private JLabel carModelLabel;
    private JLabel carColorLabel;
    private JLabel carLicensePlateLabel;


    private JTextField firstnameTextField;
    private JTextField lastnameTextField;
    private JTextField userIDTextField;
    private JPasswordField passwordTextField;
    private JPasswordField confirmPasswordTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JTextField driversLicenseTextField;
    private JTextField carModelTextField;
    private JTextField carColorTextField;
    private JTextField carLicensePlateTextField;

    private JButton registerButton;
    private JButton cancelButton;
    private JButton resetButton;
    private JButton loginButton;

    public RegistrationView() {
        frame = new JFrame("New User Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        

        firstnameLabel = new JLabel("First Name");
        lastnameLabel = new JLabel("Last Name");
        userIDLabel = new JLabel("User ID");
        passwordLabel = new JLabel("Password");
        confirmPasswordLabel = new JLabel("Confirm Password");
        emailLabel = new JLabel("Email");
        phoneLabel = new JLabel("Phone Number");
        driversLicenseLabel = new JLabel("Drivers License");
        carModelLabel = new JLabel("Car Model");
        carColorLabel = new JLabel("Car Color");
        carLicensePlateLabel = new JLabel("Car License Plate");

        firstnameTextField = new JTextField();
        lastnameTextField = new JTextField();
        userIDTextField = new JTextField();
        passwordTextField = new JPasswordField();
        confirmPasswordTextField = new JPasswordField();
        emailTextField = new JTextField();
        phoneTextField = new JTextField();
        driversLicenseTextField = new JTextField();
        carModelTextField = new JTextField();
        carColorTextField = new JTextField();
        carLicensePlateTextField = new JTextField();

        registerButton = new JButton("Register");
        cancelButton = new JButton("Cancel");
        resetButton = new JButton("Reset");
        loginButton = new JButton("Login");

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(firstnameLabel)
                        .addComponent(lastnameLabel)
                        .addComponent(userIDLabel)
                        .addComponent(passwordLabel)
                        .addComponent(confirmPasswordLabel)
                        .addComponent(emailLabel)
                        .addComponent(phoneLabel)
                        .addComponent(driversLicenseLabel)
                        .addComponent(carModelLabel)
                        .addComponent(carColorLabel)
                        .addComponent(carLicensePlateLabel))
                    .addGroup(layout.createParallelGroup()
                        .addComponent(firstnameTextField)
                        .addComponent(lastnameTextField)
                        .addComponent(userIDTextField)
                        .addComponent(passwordTextField)
                        .addComponent(confirmPasswordTextField)
                        .addComponent(emailTextField)
                        .addComponent(phoneTextField)
                        .addComponent(driversLicenseTextField)
                        .addComponent(carModelTextField)
                        .addComponent(carColorTextField)
                        .addComponent(carLicensePlateTextField)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(registerButton)
                .addComponent(cancelButton)
                .addComponent(resetButton)
                .addComponent(loginButton))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(firstnameLabel)
                        .addComponent(firstnameTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(lastnameLabel)
                        .addComponent(lastnameTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(userIDLabel)
                        .addComponent(userIDTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(passwordLabel)
                        .addComponent(passwordTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(confirmPasswordLabel)
                        .addComponent(confirmPasswordTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(emailLabel)
                        .addComponent(emailTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(phoneLabel)
                        .addComponent(phoneTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(driversLicenseLabel)
                        .addComponent(driversLicenseTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(carModelLabel)
                        .addComponent(carModelTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(carColorLabel)
                        .addComponent(carColorTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(carLicensePlateLabel)
                        .addComponent(carLicensePlateTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(registerButton)
                        .addComponent(cancelButton)
                        .addComponent(resetButton)
                        .addComponent(loginButton)));
    }

    public JFrame getFrame() {
        return frame;
    }
    public JLabel getFirstnameLabel() {
        return firstnameLabel;
    }
    public JLabel getLastnameLabel() {
        return lastnameLabel;
    }
    public JLabel getUserIDLabel() {
        return userIDLabel;
    }
    public JLabel getPasswordLabel() {
        return passwordLabel;
    }
    public JLabel getConfirmPasswordLabel() {
        return confirmPasswordLabel;
    }
    public JLabel getEmailLabel() {
        return emailLabel;
    }
    public JLabel getPhoneLabel() {
        return phoneLabel;
    }
    public JLabel getDriversLicenseLabel() {
        return driversLicenseLabel;
    }
    public JLabel getCarModelLabel() {
        return carModelLabel;
    }
    public JLabel getCarColorLabel() {
        return carColorLabel;
    }
    public JLabel getCarLicensePlateLabel() {
        return carLicensePlateLabel;
    }
    public JTextField getFirstnameTextField() {
        return firstnameTextField;
    }
    public JTextField getLastnameTextField() {
        return lastnameTextField;
    }
    public JTextField getUserIDTextField() {
        return userIDTextField;
    }
    public JTextField getPasswordTextField() {
        return passwordTextField;
    }
    public JTextField getConfirmPasswordTextField() {
        return confirmPasswordTextField;
    }
    public JTextField getEmailTextField() {
        return emailTextField;
    }
    public JTextField getPhoneTextField() {
        return phoneTextField;
    }
    public JTextField getDriversLicenseTextField() {
        return driversLicenseTextField;
    }
    public JTextField getCarModelTextField() {
        return carModelTextField;
    }
    public JTextField getCarColorTextField() {
        return carColorTextField;
    }
    public JTextField getCarLicensePlateTextField() {
        return carLicensePlateTextField;
    }
    public JButton getRegisterButton() {
        return registerButton;
    }
    public JButton getCancelButton() {
        return cancelButton;
    }
    public JButton getResetButton() {
        return resetButton;
    }
    public JButton getLoginButton() {
        return loginButton;
    }
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    public void disposeFrame() {
        frame.setVisible(false);
        frame.dispose();
        Database database = new Database("mongodb://localhost:27017", "parkingSystem", "users");
        Database database_loggedinusers = new Database("mongodb://localhost:27017", "parkingSystem", "loggedinusers");
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView, database, database_loggedinusers);
        loginController.initLoginController();
    }
    public void setFirstnameLabel(JLabel firstnameLabel) {
        this.firstnameLabel = firstnameLabel;
    }
    public void setLastnameLabel(JLabel lastnameLabel) {
        this.lastnameLabel = lastnameLabel;
    }
    public void setUserIDLabel(JLabel userIDLabel) {
        this.userIDLabel = userIDLabel;
    }
    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }
    public void setConfirmPasswordLabel(JLabel confirmPasswordLabel) {
        this.confirmPasswordLabel = confirmPasswordLabel;
    }
    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }
    public void setPhoneLabel(JLabel phoneLabel) {
        this.phoneLabel = phoneLabel;
    }
    public void setDriversLicenseLabel(JLabel driversLicenseLabel) {
        this.driversLicenseLabel = driversLicenseLabel;
    }
    public void setCarModelLabel(JLabel carModelLabel) {
        this.carModelLabel = carModelLabel;
    }
    public void setCarColorLabel(JLabel carColorLabel) {
        this.carColorLabel = carColorLabel;
    }
    public void setCarLicensePlateLabel(JLabel carLicensePlateLabel) {
        this.carLicensePlateLabel = carLicensePlateLabel;
    }
    public void setFirstnameTextField(JTextField firstnameTextField) {
        this.firstnameTextField = firstnameTextField;
    }
    public void setLastnameTextField(JTextField lastnameTextField) {
        this.lastnameTextField = lastnameTextField;
    }
    public void setUserIDTextField(JTextField userIDTextField) {
        this.userIDTextField = userIDTextField;
    }
    public void setPasswordTextField(JPasswordField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }
    public void setConfirmPasswordTextField(JPasswordField confirmPasswordTextField) {
        this.confirmPasswordTextField = confirmPasswordTextField;
    }
    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }
    public void setPhoneTextField(JTextField phoneTextField) {
        this.phoneTextField = phoneTextField;
    }
    public void setDriversLicenseTextField(JTextField driversLicenseTextField) {
        this.driversLicenseTextField = driversLicenseTextField;
    }
    public void setCarModelTextField(JTextField carModelTextField) {
        this.carModelTextField = carModelTextField;
    }
    public void setCarColorTextField(JTextField carColorTextField) {
        this.carColorTextField = carColorTextField;
    }
    public void setCarLicensePlateTextField(JTextField carLicensePlateTextField) {
        this.carLicensePlateTextField = carLicensePlateTextField;
    }
    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }
    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }
    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }
}
