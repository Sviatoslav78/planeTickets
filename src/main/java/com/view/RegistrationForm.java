package com.view;

import com.controller.SignUpController;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm {
    private JTextField nameField;
    private JTextField mailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JPanel signUpForm;
    private JButton registerButton;
    private JButton returnButton;

    private SignUpController signUpController = new SignUpController();

    public RegistrationForm() {
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                MainForm.getMainFrame().setVisible(true);
                MainForm.getSignUpFrame().setVisible(false);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(nameField.getText().equals("") || mailField.getText().equals("") || String.valueOf(passwordField.getPassword()).equals("") ||
                        String.valueOf(confirmPasswordField.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "Not all fields are filled!");
                } else {
                    signUpController.register(nameField.getText(), mailField.getText(), String.valueOf(passwordField.getPassword()),
                            String.valueOf(confirmPasswordField.getPassword()));
                }
            }
        });
    }

    public JPanel getSignUpForm() {
        return signUpForm;
    }
}
