package com.view;

import com.controller.SignInController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInForm {
    private JPanel signInForm;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton returnButton;

    private SignInController signInController;

    public JPanel getSignInForm() {
        return signInForm;
    }

    public SignInForm() {
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                signInController = new SignInController();
                switch (signInController.login(loginField.getText(), String.valueOf(passwordField.getPassword()))) {
                    case USER:
                        break;
                    case ADMIN:
                        break;
                    case NOT_DEFINED:
                        break;
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                MainForm.getMainFrame().setVisible(true);
                MainForm.getSignInFrame().setVisible(false);
            }
        });
    }

}
