package com.parkingmvc.WelcomeBack;

import javax.swing.JOptionPane;
import org.bson.Document;
import com.parkingmvc.Database;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.lang.Math;

import com.parkingmvc.UserLogin.LoginModel;

public class WelcomeBackController {

    private WelcomeBackView welcomeBackView;
    private Database database_loggedinusers;

    public WelcomeBackController(WelcomeBackView welcomeBackView, Database database_loggedinusers) {
        this.welcomeBackView = welcomeBackView;
        this.database_loggedinusers = database_loggedinusers;
    }

    public void initWelcomeBackController() {
        welcomeBackView.getProceedButton().addActionListener(e -> {
            String userID = LoginModel.getUserID();
            String currentTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            database_loggedinusers.insertEndTime(userID, currentTimeStamp);

            String startTime = database_loggedinusers.getLoggedInUserStartTime(userID);
            String endTime = database_loggedinusers.getLoggedInUserEndTime(userID);

            String[] startTimeArray = startTime.split("\\.");
            String[] endTimeArray = endTime.split("\\.");
            int startTimeYear = Integer.parseInt(startTimeArray[0]);
            int startTimeMonth = Integer.parseInt(startTimeArray[1]);
            int startTimeDay = Integer.parseInt(startTimeArray[2]);
            int startTimeHour = Integer.parseInt(startTimeArray[3]);
            int startTimeMinute = Integer.parseInt(startTimeArray[4]);
            int startTimeSecond = Integer.parseInt(startTimeArray[5]);
            int endTimeYear = Integer.parseInt(endTimeArray[0]);
            int endTimeMonth = Integer.parseInt(endTimeArray[1]);
            int endTimeDay = Integer.parseInt(endTimeArray[2]);
            int endTimeHour = Integer.parseInt(endTimeArray[3]);
            int endTimeMinute = Integer.parseInt(endTimeArray[4]);
            int endTimeSecond = Integer.parseInt(endTimeArray[5]);
            
            double startTimeInSeconds = startTimeYear * 365 * 24 * 60 * 60 + startTimeMonth * 30 * 24 * 60 * 60 + startTimeDay * 24 * 60 * 60 + startTimeHour * 60 * 60 + startTimeMinute * 60 + startTimeSecond;
            double endTimeInSeconds = endTimeYear * 365 * 24 * 60 * 60 + endTimeMonth * 30 * 24 * 60 * 60 + endTimeDay * 24 * 60 * 60 + endTimeHour * 60 * 60 + endTimeMinute * 60 + endTimeSecond;
            double totalTimeInSeconds = endTimeInSeconds - startTimeInSeconds;
            double totalTimeInMinutes = totalTimeInSeconds / 60;
            double totalTimeInHours = totalTimeInMinutes / 60;

            database_loggedinusers.insertTotalTimeParked(userID, totalTimeInHours);

            JOptionPane.showMessageDialog(null, "You have parked your car for " + String.format("%.1f", totalTimeInHours) + " hours"  + " From " + startTime + " to " + endTime);
            welcomeBackView.disposeFrameWelcomeBack();
        });

        welcomeBackView.getCancelButton().addActionListener(e -> {
            String userID = LoginModel.getUserID();
            database_loggedinusers.setLoginWelcomeBackStatus(userID, false);
            welcomeBackView.disposeFrameWelcomeBack();
            System.exit(0);
        });
    }
    
}
