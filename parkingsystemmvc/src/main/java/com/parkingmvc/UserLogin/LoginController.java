package com.parkingmvc.UserLogin;

import javax.swing.JOptionPane;
import org.bson.Document;
import com.parkingmvc.Database;

public class LoginController {

    private LoginView loginView;
    private Database database;
    private Database database_loggedinusers;

    public LoginController(LoginView loginView, Database database, Database database_loggedinusers) {
        this.loginView = loginView;
        this.database = database;
        this.database_loggedinusers = database_loggedinusers;
    }

    public void initLoginController() {
        loginView.getBtnLogin().addActionListener(e -> {
            String userID = loginView.getTxtUserID().getText();
            if (userID.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your user ID.");
                return;
            }
            String password = loginView.getTxtPassword().getText();
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your password.");
                return;
            }
            Document loggedinuser = database_loggedinusers.getLoggedInUser(userID);
            if (loggedinuser == null) {
                Document user = database.getUser(userID);
                if (user == null) {
                    JOptionPane.showMessageDialog(null, "User ID does not exist.");
                    return;
                }
                if (database.verifyPassword(password) == false) {
                    JOptionPane.showMessageDialog(null, "Password is incorrect.");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Login successful.");
    
                LoginModel.setUserID(userID);
    
                Database database2 = new Database("mongodb://localhost:27017", "parkingSystem", "loggedinusers");
                database2.insertLoggedInUser(userID);
    
                loginView.disposeFrame();
            }
            else {
                LoginModel.setUserID(userID);
                Database database3 = new Database("mongodb://localhost:27017", "parkingSystem", "loggedinusers");
                database3.setLoginWelcomeBackStatus(userID, true);
                loginView.disposeFrameAndShowWelcomeBackView();
            }
        });

        loginView.getBtnReset().addActionListener(e -> {
            loginView.getTxtUserID().setText("");
            loginView.getTxtPassword().setText("");
        });

        loginView.getBtnCancel().addActionListener(e -> {
            System.exit(0);
        });
    } 
}
