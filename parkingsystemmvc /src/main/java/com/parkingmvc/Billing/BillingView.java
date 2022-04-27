package com.parkingmvc.Billing;

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
import com.parkingmvc.FeedBack.*;

public class BillingView {

    private JFrame frame;
    private JPanel panel;

    private JLabel bill_details;
    private JLabel bill_amount;
    private JLabel payment_method;

    private JRadioButton credit_card;
    private JRadioButton cash;
    private JRadioButton debit_card;
    private JRadioButton paypal;
    private JRadioButton bitcoin;
    private JRadioButton UPIAccount;
    private JRadioButton netbanking;

    private JLabel spacing; 

    private JButton proceedButton;
    private JButton cancelButton;

    private double total_amount;


    public BillingView() {
        frame = new JFrame("Billing");
        panel = new JPanel();

        String userID = LoginModel.getUserID();
        Database database_loggedinuser = new Database("mongodb://localhost:27017", "parkingSystem", "loggedinusers");
        Database database_users = new Database("mongodb://localhost:27017", "parkingSystem", "users");
        String userName = database_users.getUserFullName(userID);
        double totalTimeParked = database_loggedinuser.getLoggedInUserTotalTimeParked(userID);
        
        // First two hours $20
        // First 3 hours: 25$
        // Every Additional hour above 3 hours: 10$
        // First 24 hours: 100$
        // Every Additional hour above 24 hours: 20$

        if (totalTimeParked <= 2) {
            total_amount = 20;
        } else if (totalTimeParked <= 3 && totalTimeParked > 2) {
            total_amount = 25;
        } else if (totalTimeParked > 3 && totalTimeParked < 24) {
            total_amount = 25 + (totalTimeParked - 3) * 10;
        } else if (totalTimeParked == 24) {
            total_amount = 100;
        } else {
            total_amount = 100 + (totalTimeParked - 24) * 10;
        }

        bill_details = new JLabel("Bill Details for " + userName);
        bill_amount = new JLabel("Total Amount: $" + total_amount);
        payment_method = new JLabel("Select a Payment Method");

        credit_card = new JRadioButton("Credit Card");
        cash = new JRadioButton("Cash");
        debit_card = new JRadioButton("Debit Card");
        paypal = new JRadioButton("Paypal");
        bitcoin = new JRadioButton("Bitcoin");
        UPIAccount = new JRadioButton("UPI Account");
        netbanking = new JRadioButton("Net Banking");

        proceedButton = new JButton("Proceed");
        cancelButton = new JButton("Cancel");

        spacing = new JLabel(" ");

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bill_details)
                        .addComponent(spacing)
                        .addComponent(bill_amount)
                        .addComponent(spacing)
                        .addComponent(payment_method)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(credit_card)
                        .addComponent(cash)
                        .addComponent(debit_card)
                        .addComponent(paypal)
                        .addComponent(bitcoin)
                        .addComponent(UPIAccount)
                        .addComponent(netbanking))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(proceedButton)
                        .addComponent(cancelButton))));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(bill_details)
                .addComponent(spacing)
                .addComponent(bill_amount)
                .addComponent(spacing)
                .addComponent(payment_method)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(credit_card)
                .addComponent(cash)
                .addComponent(debit_card)
                .addComponent(paypal)
                .addComponent(bitcoin)
                .addComponent(UPIAccount)
                .addComponent(netbanking))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(proceedButton)
                .addComponent(cancelButton)));

        frame.add(panel);
        frame.setSize(800, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void disposeFrameBilling() {
        frame.setVisible(false);
        frame.dispose();
        FeedBackView feedBackView = new FeedBackView();
        FeedBackController feedBackController = new FeedBackController(feedBackView);
        feedBackController.initFeedBackController();
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getBill_details() {
        return bill_details;
    }

    public JLabel getBill_amount() {
        return bill_amount;
    }

    public JLabel getPayment_method() {
        return payment_method;
    }

    public JRadioButton getCredit_card() {
        return credit_card;
    }

    public JRadioButton getCash() {
        return cash;
    }

    public JRadioButton getDebit_card() {
        return debit_card;
    }

    public JRadioButton getPaypal() {
        return paypal;
    }

    public JRadioButton getBitcoin() {
        return bitcoin;
    }

    public JRadioButton getUPIAccount() {
        return UPIAccount;
    }

    public JRadioButton getNetbanking() {
        return netbanking;
    }

    public JButton getProceedButton() {
        return proceedButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JLabel getSpacing() {
        return spacing;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void setBill_details(JLabel bill_details) {
        this.bill_details = bill_details;
    }

    public void setBill_amount(JLabel bill_amount) {
        this.bill_amount = bill_amount;
    }

    public void setPayment_method(JLabel payment_method) {
        this.payment_method = payment_method;
    }

    public void setCredit_card(JRadioButton credit_card) {
        this.credit_card = credit_card;
    }

    public void setCash(JRadioButton cash) {
        this.cash = cash;
    }

    public void setDebit_card(JRadioButton debit_card) {
        this.debit_card = debit_card;
    }

    public void setPaypal(JRadioButton paypal) {
        this.paypal = paypal;
    }

    public void setBitcoin(JRadioButton bitcoin) {
        this.bitcoin = bitcoin;
    }

    public void setUPIAccount(JRadioButton UPIAccount) {
        this.UPIAccount = UPIAccount;
    }

    public void setNetbanking(JRadioButton netbanking) {
        this.netbanking = netbanking;
    }

    public void setProceedButton(JButton proceedButton) {
        this.proceedButton = proceedButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public void setSpacing(JLabel spacing) {
        this.spacing = spacing;
    }
    
}
