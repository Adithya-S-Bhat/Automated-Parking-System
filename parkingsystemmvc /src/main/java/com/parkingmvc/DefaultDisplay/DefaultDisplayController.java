package com.parkingmvc.DefaultDisplay;

import javax.swing.JOptionPane;
import org.bson.Document;
import com.parkingmvc.Database;

public class DefaultDisplayController {

    private DefaultDisplayView defaultDisplayView;
    
    public DefaultDisplayController(DefaultDisplayView defaultDisplayView) {
        this.defaultDisplayView = defaultDisplayView;
    }

    public void initDefaultDisplayController(){
        defaultDisplayView.getBtnProceed().addActionListener(e -> {
            String option = defaultDisplayView.getRbAdmin().isSelected() ? "Admin" : "User";
            if (option.equals("")) {
                JOptionPane.showMessageDialog(null, "Please select an option.");
                return;
            }
            if (option.equals("Admin")) {
                JOptionPane.showMessageDialog(null, "You have selected Admin.");
                defaultDisplayView.disposeFrameAdmin();
                return;
            }
            if (option.equals("User")) {
                JOptionPane.showMessageDialog(null, "You have selected User.");
                defaultDisplayView.disposeFrameUser();
                return;
            }
        });
    } 
}
