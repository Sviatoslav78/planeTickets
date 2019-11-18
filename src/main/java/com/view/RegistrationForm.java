package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm {
    private JTextField nameField;
    private JTextField passportIdField;
    private JTextField mailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JPanel signUpForm;
    private JButton registerButton;
    private JButton returnButton;


    public RegistrationForm() {
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                MainForm.getMainFrame().setVisible(true);
                MainForm.getSignUpFrame().setVisible(false);
            }
        });
    }

    public JPanel getSignUpForm() {
        return signUpForm;
    }
}
