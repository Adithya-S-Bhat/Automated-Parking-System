package com.parkingmvc.DefaultDisplay;

import com.parkingmvc.UserRegistration.*;
import com.parkingmvc.Admin.*;
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

public class DefaultDisplayView{

    private JFrame frame;
    // Create two radio buttons giving options for admin or normal user
    private JRadioButton rbAdmin;
    private JRadioButton rbUser;
    // Create a heading for the JFrame
    private JLabel lblHeading;
    private JButton btnProceed;

    public DefaultDisplayView(){
        frame = new JFrame("Parking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);

        lblHeading = new JLabel("Are you an Admin or a User?");

        rbAdmin = new JRadioButton("Admin");
        rbUser = new JRadioButton("User");

        btnProceed = new JButton("Proceed");


        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup())
                .addGroup(layout.createParallelGroup()
                        .addComponent(lblHeading)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(rbAdmin)
                        .addComponent(rbUser)))
                .addGroup(layout.createParallelGroup()
                        .addComponent(btnProceed)));

        layout.setVerticalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(lblHeading))
                .addGroup(layout.createParallelGroup()
                        .addComponent(rbAdmin)
                        .addComponent(rbUser))
                .addGroup(layout.createParallelGroup()
                        .addComponent(btnProceed))));
    }

    public JFrame getFrame(){
        return frame;
    }
    public JRadioButton getRbAdmin(){
        return rbAdmin;
    }
    public JRadioButton getRbUser(){
        return rbUser;
    }
    public JLabel getLblHeading(){
        return lblHeading;
    }
    public JButton getBtnProceed(){
        return btnProceed;
    }
    public void disposeFrameUser(){
        frame.setVisible(false);
        frame.dispose();
        RegistrationModel registrationModel = new RegistrationModel("", "", "", "", "", "", "", "", "", "", "");
        RegistrationView registrationView = new RegistrationView();
        Database database = new Database("mongodb://localhost:27017", "parkingSystem", "users");
        RegistrationController registrationController = new RegistrationController(registrationView, registrationModel, database);
        registrationController.initRegistrationController();
    }

    public void disposeFrameAdmin(){
        frame.setVisible(false);
        frame.dispose();
        AdminModel adminModel = new AdminModel("", 10, 0, "", "", "", "", "", "", 17.2, 19.7);
        AdminView adminView = new AdminView();
        Database database = new Database("mongodb://localhost:27017", "parkingSystem", "admin");
        AdminController adminController = new AdminController(adminView, adminModel, database);
        adminController.initAdminController();
    }
}