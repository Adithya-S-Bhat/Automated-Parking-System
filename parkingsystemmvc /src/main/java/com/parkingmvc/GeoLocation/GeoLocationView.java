package com.parkingmvc.GeoLocation;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import com.parkingmvc.Dashboard.*;
import com.parkingmvc.Database;

public class GeoLocationView {

    private JFrame frame;
    private JLabel lblHeading;
    private JButton btnAccept;
    private JButton btnReject;

    public GeoLocationView(){
        frame = new JFrame("Fetch GeoLocation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);

        lblHeading = new JLabel("Permission to fetch your GeoLocation");

        btnAccept = new JButton("Accept");
        btnReject = new JButton("Reject");

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                    .addComponent(lblHeading)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAccept)
                        .addComponent(btnReject))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAccept)
                .addComponent(btnReject)));
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblHeading))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(btnAccept)
                .addComponent(btnReject)));
    }

    public JFrame getFrame(){
        return frame;
    }
    public JLabel getLblHeading(){
        return lblHeading;
    }
    public JButton getBtnAccept(){
        return btnAccept;
    }
    public JButton getBtnReject(){
        return btnReject;
    }

    public void disposeGeoLocationPermissionFrame(){
        frame.setVisible(false);
        frame.dispose();
        DashboardView dashboardView = new DashboardView();
        DashboardModel dashboardModel = new DashboardModel("");
        Database database_loggedinusers = new Database("mongodb://localhost:27017", "parkingSystem", "loggedinusers");
        Database database_admin = new Database("mongodb://localhost:27017", "parkingSystem", "admin");
        DashboardController dashboardController = new DashboardController(dashboardView, dashboardModel, database_loggedinusers, database_admin);
        dashboardController.initDashboardController();

    }

    
}
