package com.parkingmvc;
import com.parkingmvc.DefaultDisplay.*;



public class App {

    public static void main(String[] args) {

        

        DefaultDisplayView defaultDisplayView = new DefaultDisplayView();
        DefaultDisplayController defaultDisplayController = new DefaultDisplayController(defaultDisplayView);
        defaultDisplayController.initDefaultDisplayController();

        // RegistrationModel registrationModel = new RegistrationModel("", "", "", "", "", "", "", "", "", "", "");
        // RegistrationView registrationView = new RegistrationView();
        // Database database = new Database("mongodb://localhost:27017", "parkingSystem", "users");
        // RegistrationController registrationController = new RegistrationController(registrationView, registrationModel, database);
        // registrationController.initRegistrationController();
    }
    
}
