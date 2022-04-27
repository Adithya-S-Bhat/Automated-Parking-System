package com.parkingmvc.WelcomeBack;

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

import com.parkingmvc.UserLogin.LoginModel;

import com.parkingmvc.Billing.*;

import javax.swing.*;

public class WelcomeBackView {

    private JFrame frame;
    private JPanel panel;

    private Database database_users;
    private Database database_loggedinuser;

    private JLabel welcome_label;
    private JLabel car_details_label;
    private JLabel car_number_label;
    private JLabel car_model_label;
    private JLabel car_color_label;
    private JLabel parked_slot_number_label;
    private JLabel unpark_label;

    private JLabel spacing;

    private JButton proceedButton;
    private JButton cancelButton;

    public WelcomeBackView() {
        frame = new JFrame("Welcome Back");
        panel = new JPanel();

        database_users = new Database("mongodb://localhost:27017", "parkingSystem", "users");
        database_loggedinuser = new Database("mongodb://localhost:27017", "parkingSystem", "loggedinusers");
        
        String userID = LoginModel.getUserID();
        String userName = database_users.getUserFullName(userID);
        String carModel = database_users.getUserCarModel(userID);
        String carNumber = database_users.getUserCarNumber(userID);
        String carColor = database_users.getUserCarColor(userID);
        String parkedSlotNumber = database_loggedinuser.getLoggedInUserParkedSlotNumber(userID);

        welcome_label = new JLabel("Welcome back" + "  " + userName);
        car_details_label = new JLabel("Your Car Details: ");
        car_color_label = new JLabel("Car Color: " + carColor);
        car_model_label = new JLabel("Car Model: " + carModel);
        car_number_label = new JLabel("Car Number: " + carNumber);
        parked_slot_number_label = new JLabel("You car is parked at slot number: " + parkedSlotNumber);
        unpark_label = new JLabel("Would you like to unpark your car?");

        spacing = new JLabel(" ");

        proceedButton = new JButton("Proceed");
        cancelButton = new JButton("Cancel");

        frame.setSize(700, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        panel.setLayout(new BorderLayout());

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(welcome_label)
                        .addComponent(spacing)
                        .addComponent(car_details_label)
                        .addComponent(spacing)
                        .addComponent(car_color_label)
                        .addComponent(car_model_label)
                        .addComponent(car_number_label)
                        .addComponent(spacing)
                        .addComponent(parked_slot_number_label)
                        .addComponent(spacing)
                        .addComponent(unpark_label))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addComponent(proceedButton)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                        .addComponent(welcome_label)
                        .addComponent(spacing)
                        .addComponent(car_details_label)
                        .addComponent(spacing)
                        .addComponent(car_color_label)
                        .addComponent(car_model_label)
                        .addComponent(car_number_label)
                        .addComponent(spacing)
                        .addComponent(parked_slot_number_label)
                        .addComponent(spacing)
                        .addComponent(unpark_label)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cancelButton)
                        .addComponent(proceedButton)));

        frame.add(panel);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void disposeFrameWelcomeBack() {
        frame.setVisible(false);
        frame.dispose();
        BillingView billingView = new BillingView();
        Database database_loggedinusers = new Database("mongodb://localhost:27017", "parkingSystem", "loggedinusers");
        Database database_admin = new Database("mongodb://localhost:27017", "parkingSystem", "admin");
        BillingController billingController = new BillingController(billingView, database_loggedinusers, database_admin);
        billingController.initBillingController();
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getWelcome_label() {
        return welcome_label;
    }

    public JLabel getCar_details_label() {
        return car_details_label;
    }

    public JLabel getCar_color_label() {
        return car_color_label;
    }

    public JLabel getCar_model_label() {
        return car_model_label;
    }

    public JLabel getCar_number_label() {
        return car_number_label;
    }

    public JLabel getParked_slot_number_label() {
        return parked_slot_number_label;
    }

    public JLabel getUnpark_label() {
        return unpark_label;
    }

    public JLabel getSpacing() {
        return spacing;
    }

    public JButton getProceedButton() {
        return proceedButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void setWelcome_label(JLabel welcome_label) {
        this.welcome_label = welcome_label;
    }

    public void setCar_details_label(JLabel car_details_label) {
        this.car_details_label = car_details_label;
    }

    public void setCar_color_label(JLabel car_color_label) {
        this.car_color_label = car_color_label;
    }

    public void setCar_model_label(JLabel car_model_label) {
        this.car_model_label = car_model_label;
    }

    public void setCar_number_label(JLabel car_number_label) {
        this.car_number_label = car_number_label;
    }

    public void setParked_slot_number_label(JLabel parked_slot_number_label) {
        this.parked_slot_number_label = parked_slot_number_label;
    }

    public void setUnpark_label(JLabel unpark_label) {
        this.unpark_label = unpark_label;
    }

    public void setSpacing(JLabel spacing) {
        this.spacing = spacing;
    }

    public void setProceedButton(JButton proceedButton) {
        this.proceedButton = proceedButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public Database getDatabase_users() {
        return database_users;
    }

    public void setDatabase_users(Database database_users) {
        this.database_users = database_users;
    }

    public Database getDatabase_loggedinuser() {
        return database_loggedinuser;
    }

    public void setDatabase_loggedinuser(Database database_loggedinuser) {
        this.database_loggedinuser = database_loggedinuser;
    }
    
}
