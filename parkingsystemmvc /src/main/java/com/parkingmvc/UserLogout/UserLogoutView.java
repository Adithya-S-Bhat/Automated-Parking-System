package com.parkingmvc.UserLogout;


import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.parkingmvc.Database;
import com.parkingmvc.UserLogin.LoginModel;
import com.parkingmvc.DefaultDisplay.*;


public class UserLogoutView {

    private JFrame frame;
    private JPanel panel;

    private JLabel heading1;
    private JLabel heading2;

    private JLabel spacing;


    private JLabel price2hrs;
    private JLabel price3hrs;
    private JLabel priceAdditionalAbove3hrs;
    private JLabel price24hrs;
    private JLabel priceAdditionalAbove24hrs;

    private JButton logout;

    public UserLogoutView() {

        frame = new JFrame("User Logout");
        panel = new JPanel();

        Database database_loggedinusers = new Database("mongodb://localhost:27017", "parkingSystem", "loggedinusers");
        String[] parkingInfo = database_loggedinusers.getParkingLotSelected(LoginModel.getUserID()).split("\n");
        String parkingLotSelected = parkingInfo[0];
        heading1 = new JLabel("Pricing for Parking");
        heading2 = new JLabel("The price for parking at " + parkingLotSelected + " is as follows:");

        spacing = new JLabel(" ");
        price2hrs = new JLabel("First 2 hours: 20$");
        price3hrs = new JLabel("First 3 hours: 25$");
        priceAdditionalAbove3hrs = new JLabel("Every Additional hour above 3 hours: 10$");
        price24hrs = new JLabel("First 24 hours: 100$");
        priceAdditionalAbove24hrs = new JLabel("Every Additional hour above 24 hours: 20$");

        logout = new JButton("Logout");

        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.setLayout(new BorderLayout());

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(heading1)
                        .addComponent(spacing)
                        .addComponent(heading2)
                        .addComponent(spacing)
                        .addComponent(price2hrs)
                        .addComponent(price3hrs)
                        .addComponent(priceAdditionalAbove3hrs)
                        .addComponent(price24hrs)
                        .addComponent(priceAdditionalAbove24hrs)
                        .addComponent(logout)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(heading1)
                .addComponent(spacing)
                .addComponent(heading2)
                .addComponent(spacing)
                .addComponent(price2hrs)
                .addComponent(price3hrs)
                .addComponent(priceAdditionalAbove3hrs)
                .addComponent(price24hrs)
                .addComponent(priceAdditionalAbove24hrs)
                .addComponent(logout));

        frame.add(panel);


    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void disposeFrameLogout() {
        frame.setVisible(false);
        frame.dispose();
        DefaultDisplayView defaultDisplayView = new DefaultDisplayView();
        DefaultDisplayController defaultDisplayController = new DefaultDisplayController(defaultDisplayView);
        defaultDisplayController.initDefaultDisplayController();
    }

    public JLabel getHeading1() {
        return heading1;
    }

    public JLabel getHeading2() {
        return heading2;
    }

    public JLabel getSpacing() {
        return spacing;
    }

    public JLabel getPrice2hrs() {
        return price2hrs;
    }

    public JLabel getPrice3hrs() {
        return price3hrs;
    }

    public JLabel getPriceAdditionalAbove3hrs() {
        return priceAdditionalAbove3hrs;
    }

    public JLabel getPrice24hrs() {
        return price24hrs;
    }

    public JLabel getPriceAdditionalAbove24hrs() {
        return priceAdditionalAbove24hrs;
    }

    public JButton getLogout() {
        return logout;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void setHeading1(JLabel heading1) {
        this.heading1 = heading1;
    }

    public void setHeading2(JLabel heading2) {
        this.heading2 = heading2;
    }

    public void setSpacing(JLabel spacing) {
        this.spacing = spacing;
    }

    public void setPrice2hrs(JLabel price2hrs) {
        this.price2hrs = price2hrs;
    }

    public void setPrice3hrs(JLabel price3hrs) {
        this.price3hrs = price3hrs;
    }

    public void setPriceAdditionalAbove3hrs(JLabel priceAdditionalAbove3hrs) {
        this.priceAdditionalAbove3hrs = priceAdditionalAbove3hrs;
    }

    public void setPrice24hrs(JLabel price24hrs) {
        this.price24hrs = price24hrs;
    }

    public void setPriceAdditionalAbove24hrs(JLabel priceAdditionalAbove24hrs) {
        this.priceAdditionalAbove24hrs = priceAdditionalAbove24hrs;
    }

    public void setLogout(JButton logout) {
        this.logout = logout;
    } 
}
