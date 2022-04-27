package com.parkingmvc.FeedBack;


import com.parkingmvc.Database;
import javax.swing.JOptionPane;
import org.bson.Document;

public class FeedBackController {

    private FeedBackView feedBackView;

    public FeedBackController(FeedBackView feedBackView) {
        this.feedBackView = feedBackView;
    }

    public void initFeedBackController() {
        feedBackView.getSubmitButton().addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Thank you for your feedback.");
            feedBackView.disposeFrameFeedBack();
        });
    }
    
}
