package com.parkingmvc.UserLogout;


import javax.swing.JOptionPane;
import org.bson.Document;
import com.parkingmvc.Database;
import com.parkingmvc.UserLogin.LoginModel;
import java.text.SimpleDateFormat;
import java.util.Date;
public class UserLogoutController {
    
    private UserLogoutView userLogoutView;
    private Database database_loggedinusers;
    
    public UserLogoutController(UserLogoutView userLogoutView,Database database_loggedinusers) {
        this.userLogoutView = userLogoutView;
        this.database_loggedinusers = database_loggedinusers;
    }
    
    public void initUserLogoutController() {
        userLogoutView.getLogout().addActionListener(e -> {
            // get user id
            String userID = LoginModel.getUserID();
            String currentTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            database_loggedinusers.insertStartTime(userID, currentTimeStamp);

            JOptionPane.showMessageDialog(null, "Logout successful. Thank you for using our Parking System.");
            userLogoutView.disposeFrameLogout();
            // System.exit(0);
    });
    }
}
