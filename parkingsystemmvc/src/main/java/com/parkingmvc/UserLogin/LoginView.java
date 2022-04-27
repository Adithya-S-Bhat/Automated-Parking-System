package com.parkingmvc.UserLogin;

import com.parkingmvc.GeoLocation.*;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.parkingmvc.WelcomeBack.*;
import com.parkingmvc.Database;

public class LoginView {

    private JFrame frame;
    private JLabel lblUserID;
    private JLabel lblPassword;
    private JTextField txtUserID;
    private JTextField txtPassword;
    private JButton btnLogin;
    private JButton btnReset;
    private JButton btnCancel;

    public LoginView(){
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);

        lblUserID = new JLabel("User ID");
        lblPassword = new JLabel("Password");
        txtUserID = new JTextField(20);
        txtPassword = new JTextField(20);
        btnLogin = new JButton("Login");
        btnReset = new JButton("Reset");
        btnCancel = new JButton("Cancel");

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(lblUserID)
                        .addComponent(lblPassword))
                .addGroup(layout.createParallelGroup()
                        .addComponent(txtUserID)
                        .addComponent(txtPassword))
                .addGroup(layout.createParallelGroup()
                        .addComponent(btnLogin)
                        .addComponent(btnReset)
                        .addComponent(btnCancel))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(lblUserID)
                        .addComponent(txtUserID)
                        .addComponent(btnLogin))
                .addGroup(layout.createParallelGroup()
                        .addComponent(lblPassword)
                        .addComponent(txtPassword)
                        .addComponent(btnReset))
                .addGroup(layout.createParallelGroup()
                        .addComponent(btnCancel))
        );
    }

    public JFrame getFrame(){
        return frame;
    }
    public void disposeFrame(){
        frame.setVisible(false);
        frame.dispose();
        GeoLocationView geoLocationView = new GeoLocationView();
        GeoLocationModel geoLocationModel = new GeoLocationModel();
        GeoLocationController geoLocationController = new GeoLocationController(geoLocationView, geoLocationModel);
        geoLocationController.initGeoLocationController();
    }

    public void disposeFrameAndShowWelcomeBackView(){
        frame.setVisible(false);
        frame.dispose();
        Database database_loggedinusers = new Database("mongodb://localhost:27017", "parkingSystem", "loggedinusers");
        WelcomeBackView welcomeBackView = new WelcomeBackView();
        WelcomeBackController welcomeBackController = new WelcomeBackController(welcomeBackView, database_loggedinusers);
        welcomeBackController.initWelcomeBackController();
    }
    public JLabel getLblUserID(){
        return lblUserID;
    }
    public JLabel getLblPassword(){
        return lblPassword;
    }
    public JTextField getTxtUserID(){
        return txtUserID;
    }
    public JTextField getTxtPassword(){
        return txtPassword;
    }
    public JButton getBtnLogin(){
        return btnLogin;
    }
    public JButton getBtnReset(){
        return btnReset;
    }
    public JButton getBtnCancel(){
        return btnCancel;
    }
}
