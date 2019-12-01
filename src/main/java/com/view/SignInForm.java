package com.view;

import com.controller.SignInController;
import com.model.Passenger;
import com.model.Plane;
import com.model.Route;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInForm {
    private JPanel signInForm;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton returnButton;

    private SignInController signInController;
    private Passenger passengerOnline;
    private AdminForm adminForm = new AdminForm();

    JFrame adminFrame = new JFrame("AdminForm");

    public JPanel getSignInForm() {
        return signInForm;
    }

    public SignInForm() {
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                signInController = new SignInController();
                passengerOnline = signInController.login(loginField.getText(), String.valueOf(passwordField.getPassword()));
                if(passengerOnline == null) {
                    JOptionPane.showMessageDialog(null, "You are not registered!");

                } else if (passengerOnline.getLogin().equals("admin")) {
                    JOptionPane.showMessageDialog(null, "You are logged in as admin");
                    adminFrame.setContentPane(adminForm.getMainAdminForm());
                    adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    adminFrame.pack();
                    adminFrame.setVisible(true);
                    adminFrame.setLocation(768,420);
                    MainForm.getSignInFrame().setVisible(false);
                    // fill BOXES
                    for (int i = 0; i < Route.values().length; i++) {
                        adminForm.getDepartureBox().addItem(Route.values()[i]);
                        adminForm.getArrivalBox().addItem(Route.values()[i]);
                    }
                    adminForm.getArrivalBox().setSelectedIndex(0);
                    adminForm.getDepartureBox().setSelectedIndex(0);

                    for (int i = 0; i < Plane.values().length; i++) {
                        adminForm.getPlaneBox().addItem(Plane.values()[i]);
                    }
                    adminForm.getPlaneBox().setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "You are logged in as a user");

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
