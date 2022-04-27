package com.parkingmvc.Admin;


import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import com.parkingmvc.DefaultDisplay.*;

public class AdminView {

    private  JFrame frame;
    private JPanel panel;

    private JLabel parkingAddressNameLabel;
    private JLabel parkingLotCapacityLabel;
    private JLabel parkingLotCapacityCurrentlyFilledLabel;
    private JLabel parkingAddressLocationLabel;
    private JLabel parkingAddressCityLabel;
    private JLabel parkingAddressStateLabel;
    private JLabel parkingAddressZipLabel;
    private JLabel parkingAddressCountryLabel;
    private JLabel parkingAddressPhoneLabel;
    private JLabel parkingAddressLatitudeLabel;
    private JLabel parkingAddressLongitudeLabel;

    private JTextField parkingAddressNameTextField;
    private JTextField parkingLotCapacityTextField;
    private JTextField parkingLotCapacityCurrentlyFilledTextField;
    private JTextField parkingAddressLocationTextField;
    private JTextField parkingAddressCityTextField;
    private JTextField parkingAddressStateTextField;
    private JTextField parkingAddressZipTextField;
    private JTextField parkingAddressCountryTextField;
    private JTextField parkingAddressPhoneTextField;
    private JTextField parkingAddressLatitudeTextField;
    private JTextField parkingAddressLongitudeTextField;

    private JButton saveButton;
    private JButton cancelButton;
    private JButton resetButton;
    private JButton deleteButton;

    public AdminView() {
        frame = new JFrame("Admin");
        panel = new JPanel();

        parkingAddressNameLabel = new JLabel("Parking Address Name");
        parkingLotCapacityLabel = new JLabel("Parking Lot Capacity");
        parkingLotCapacityCurrentlyFilledLabel = new JLabel("Parking Lot Capacity Currently Filled");
        parkingAddressLocationLabel = new JLabel("Parking Address Location");
        parkingAddressCityLabel = new JLabel("Parking Address City");
        parkingAddressStateLabel = new JLabel("Parking Address State");
        parkingAddressZipLabel = new JLabel("Parking Address Zip");
        parkingAddressCountryLabel = new JLabel("Parking Address Country");
        parkingAddressPhoneLabel = new JLabel("Parking Address Phone");
        parkingAddressLatitudeLabel = new JLabel("Parking Address Latitude");
        parkingAddressLongitudeLabel = new JLabel("Parking Address Longitude");

        parkingAddressNameTextField = new JTextField();
        parkingLotCapacityTextField = new JTextField();
        parkingLotCapacityCurrentlyFilledTextField = new JTextField();
        parkingAddressLocationTextField = new JTextField();
        parkingAddressCityTextField = new JTextField();
        parkingAddressStateTextField = new JTextField();
        parkingAddressZipTextField = new JTextField();
        parkingAddressCountryTextField = new JTextField();
        parkingAddressPhoneTextField = new JTextField();
        parkingAddressLatitudeTextField = new JTextField();
        parkingAddressLongitudeTextField = new JTextField();

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        resetButton = new JButton("Reset");
        deleteButton = new JButton("Delete");

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(parkingAddressNameLabel)
                        .addComponent(parkingLotCapacityLabel)
                        .addComponent(parkingLotCapacityCurrentlyFilledLabel)
                        .addComponent(parkingAddressLocationLabel)
                        .addComponent(parkingAddressCityLabel)
                        .addComponent(parkingAddressStateLabel)
                        .addComponent(parkingAddressZipLabel)
                        .addComponent(parkingAddressCountryLabel)
                        .addComponent(parkingAddressPhoneLabel)
                        .addComponent(parkingAddressLatitudeLabel)
                        .addComponent(parkingAddressLongitudeLabel))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(parkingAddressNameTextField)
                        .addComponent(parkingLotCapacityTextField)
                        .addComponent(parkingLotCapacityCurrentlyFilledTextField)
                        .addComponent(parkingAddressLocationTextField)
                        .addComponent(parkingAddressCityTextField)
                        .addComponent(parkingAddressStateTextField)
                        .addComponent(parkingAddressZipTextField)
                        .addComponent(parkingAddressCountryTextField)
                        .addComponent(parkingAddressPhoneTextField)
                        .addComponent(parkingAddressLatitudeTextField)
                        .addComponent(parkingAddressLongitudeTextField))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(saveButton)
                        .addComponent(cancelButton)
                        .addComponent(resetButton)
                        .addComponent(deleteButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(parkingAddressNameLabel)
                        .addComponent(parkingAddressNameTextField)
                        .addComponent(saveButton))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(parkingLotCapacityLabel)
                        .addComponent(parkingLotCapacityTextField)
                        .addComponent(cancelButton))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(parkingLotCapacityCurrentlyFilledLabel)
                        .addComponent(parkingLotCapacityCurrentlyFilledTextField)
                        .addComponent(resetButton))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(parkingAddressLocationLabel)
                        .addComponent(parkingAddressLocationTextField)
                        .addComponent(deleteButton))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(parkingAddressCityLabel)
                        .addComponent(parkingAddressCityTextField))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(parkingAddressStateLabel)
                        .addComponent(parkingAddressStateTextField))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(parkingAddressZipLabel)
                        .addComponent(parkingAddressZipTextField))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(parkingAddressCountryLabel)
                        .addComponent(parkingAddressCountryTextField))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(parkingAddressPhoneLabel)
                        .addComponent(parkingAddressPhoneTextField))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(parkingAddressLatitudeLabel)
                        .addComponent(parkingAddressLatitudeTextField))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(parkingAddressLongitudeLabel)
                        .addComponent(parkingAddressLongitudeTextField))
        );

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
    }

    public JFrame getFrame() {
        return frame;
    }
    public JPanel getPanel() {
        return panel;
    }

    public void disposeFrameAdmin(){
        frame.setVisible(false);
        frame.dispose();
        DefaultDisplayView defaultDisplayView = new DefaultDisplayView();
        DefaultDisplayController defaultDisplayController = new DefaultDisplayController(defaultDisplayView);
        defaultDisplayController.initDefaultDisplayController();
    }

    public JLabel getParkingAddressNameLabel() {
        return parkingAddressNameLabel;
    }
    public JLabel getParkingLotCapacityLabel() {
        return parkingLotCapacityLabel;
    }
    public JLabel getParkingLotCapacityCurrentlyFilledLabel() {
        return parkingLotCapacityCurrentlyFilledLabel;
    }
    public JLabel getParkingAddressLocationLabel() {
        return parkingAddressLocationLabel;
    }
    public JLabel getParkingAddressCityLabel() {
        return parkingAddressCityLabel;
    }
    public JLabel getParkingAddressStateLabel() {
        return parkingAddressStateLabel;
    }
    public JLabel getParkingAddressZipLabel() {
        return parkingAddressZipLabel;
    }
    public JLabel getParkingAddressCountryLabel() {
        return parkingAddressCountryLabel;
    }
    public JLabel getParkingAddressPhoneLabel() {
        return parkingAddressPhoneLabel;
    }
    public JLabel getParkingAddressLatitudeLabel() {
        return parkingAddressLatitudeLabel;
    }
    public JLabel getParkingAddressLongitudeLabel() {
        return parkingAddressLongitudeLabel;
    }

    public JTextField getParkingAddressNameTextField() {
        return parkingAddressNameTextField;
    }
    public JTextField getParkingLotCapacityTextField() {
        return parkingLotCapacityTextField;
    }
    public JTextField getParkingLotCapacityCurrentlyFilledTextField() {
        return parkingLotCapacityCurrentlyFilledTextField;
    }
    public JTextField getParkingAddressLocationTextField() {
        return parkingAddressLocationTextField;
    }
    public JTextField getParkingAddressCityTextField() {
        return parkingAddressCityTextField;
    }
    public JTextField getParkingAddressStateTextField() {
        return parkingAddressStateTextField;
    }
    public JTextField getParkingAddressZipTextField() {
        return parkingAddressZipTextField;
    }
    public JTextField getParkingAddressCountryTextField() {
        return parkingAddressCountryTextField;
    }
    public JTextField getParkingAddressPhoneTextField() {
        return parkingAddressPhoneTextField;
    }
    public JTextField getParkingAddressLatitudeTextField() {
        return parkingAddressLatitudeTextField;
    }
    public JTextField getParkingAddressLongitudeTextField() {
        return parkingAddressLongitudeTextField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
    public JButton getCancelButton() {
        return cancelButton;
    }
    public JButton getResetButton() {
        return resetButton;
    }
    public JButton getDeleteButton() {
        return deleteButton;
    }
}

