package com.parkingmvc.FeedBack;

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

public class FeedBackView {

    private JFrame frame;
    private JPanel panel;

    private JLabel feedBackTextJLabel;
    private JLabel feedBackRatingJLabel;

    private JTextField feedBackTextJTextField;

    private JRadioButton rating1;
    private JRadioButton rating2;
    private JRadioButton rating3;
    private JRadioButton rating4;
    private JRadioButton rating5;

    private JLabel spacing;

    private JButton SubmitButton;

    public FeedBackView(){
        frame = new JFrame("FeedBack");
        panel = new JPanel();

        feedBackTextJLabel = new JLabel("Please enter your feedback:");
        feedBackRatingJLabel = new JLabel("Rate your experience:");

        feedBackTextJTextField = new JTextField();

        rating1 = new JRadioButton("1");
        rating2 = new JRadioButton("2");
        rating3 = new JRadioButton("3");
        rating4 = new JRadioButton("4");
        rating5 = new JRadioButton("5");

        spacing = new JLabel(" ");

        SubmitButton = new JButton("Submit");

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(feedBackTextJLabel)
                        .addComponent(feedBackRatingJLabel)
                        .addComponent(feedBackTextJTextField)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(rating1)
                                .addComponent(rating2)
                                .addComponent(rating3)
                                .addComponent(rating4)
                                .addComponent(rating5))
                        .addComponent(spacing)
                        .addComponent(SubmitButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(feedBackTextJLabel)
                .addComponent(feedBackTextJTextField)
                .addComponent(feedBackRatingJLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(rating1)
                        .addComponent(rating2)
                        .addComponent(rating3)
                        .addComponent(rating4)
                        .addComponent(rating5))
                .addComponent(spacing)
                .addComponent(SubmitButton)
        );

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

    public void disposeFrameFeedBack(){
        frame.setVisible(false);
        frame.dispose();
        System.exit(0);
    }

    public JTextField getFeedBackTextJTextField() {
        return feedBackTextJTextField;
    }

    public JRadioButton getRating1() {
        return rating1;
    }

    public JRadioButton getRating2() {
        return rating2;
    }

    public JRadioButton getRating3() {
        return rating3;
    }

    public JRadioButton getRating4() {
        return rating4;
    }

    public JRadioButton getRating5() {
        return rating5;
    }

    public JButton getSubmitButton() {
        return SubmitButton;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setFeedBackTextJTextField(JTextField feedBackTextJTextField) {
        this.feedBackTextJTextField = feedBackTextJTextField;
    }

    public void setRating1(JRadioButton rating1) {
        this.rating1 = rating1;
    }

    public void setRating2(JRadioButton rating2) {
        this.rating2 = rating2;
    }

    public void setRating3(JRadioButton rating3) {
        this.rating3 = rating3;
    }

    public void setRating4(JRadioButton rating4) {
        this.rating4 = rating4;
    }

    public void setRating5(JRadioButton rating5) {
        this.rating5 = rating5;
    }

    public void setSubmitButton(JButton SubmitButton) {
        this.SubmitButton = SubmitButton;
    }

    public void setSpacing(JLabel spacing) {
        this.spacing = spacing;
    }

    public JLabel getSpacing() {
        return spacing;
    }

    public void setFeedBackRatingJLabel(JLabel feedBackRatingJLabel) {
        this.feedBackRatingJLabel = feedBackRatingJLabel;
    }
}
