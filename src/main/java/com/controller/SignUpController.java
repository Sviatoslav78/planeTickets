package com.controller;

import com.model.Flight;
import com.model.Passenger;
import com.service.PassengerSevice;
import com.view.MainForm;
import com.view.RegistrationForm;

import javax.swing.*;
import java.util.ArrayList;

public class SignUpController {

    PassengerSevice passengerSevice = new PassengerSevice();

    public void register(String name, String login, String password, String confirmPassword) {
        Passenger passenger = new Passenger(name, login, password, new ArrayList<Flight>());
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match!");
        } else if (password.length() < 4) {
            JOptionPane.showMessageDialog(null, "Password is too short!");
        } else if (name.length() < 4) {
            JOptionPane.showMessageDialog(null, "Please, write your real name!");
        } else if (passengerSevice.exists(passenger) || login.equalsIgnoreCase("admin")) {
            JOptionPane.showMessageDialog(null, "This login is already registered!");
        } else {
            passengerSevice.createNew(passenger);
            JOptionPane.showMessageDialog(null, "You are successfully registered!\n\nYou can use your log/password to sign in");
            MainForm.getSignUpFrame().setVisible(false);
            MainForm.getMainFrame().setVisible(true);
        }
    }
}
