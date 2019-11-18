package com.view;

import com.model.Flight;
import com.model.Passenger;
import com.model.Plane;
import com.model.Route;
import com.service.FlightService;
import com.service.HibernateFactory;
import com.service.PassengerSevice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainForm {
    private JButton loginButton;
    private JButton registerButton;
    private JPanel mainFormField;

    private static JFrame mainFrame = new JFrame("MainForm");
    private static JFrame signInFrame = new JFrame("SignInForm");
    private static JFrame signUpFrame = new JFrame("RegistrationForm");

    private static FlightService flightService = new FlightService();
    private static PassengerSevice passengerSevice = new PassengerSevice();


    public static JFrame getMainFrame() {
        return mainFrame;
    }

    public static JFrame getSignInFrame() {
        return signInFrame;
    }

    public static JFrame getSignUpFrame() {
        return signUpFrame;
    }

    public MainForm() {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                signInFrame.setContentPane(new SignInForm().getSignInForm());
                signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                signInFrame.pack();
                signInFrame.setVisible(true);
                mainFrame.setVisible(false);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                signUpFrame.setContentPane(new RegistrationForm().getSignUpForm());
                signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                signUpFrame.pack();
                signUpFrame.setVisible(true);
                mainFrame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        HibernateFactory.HIBERNATE_FACTORY.getSessionFactory().openSession();

        Flight flight = new Flight(Route.BERLIN.getName(), Route.KYIV.getName(), new GregorianCalendar(2019, Calendar.NOVEMBER, 17, 16,17), Plane.Boeing.getName(), new ArrayList<Passenger>());
        Passenger passenger = new Passenger("Katya", 1000, new ArrayList<Flight>());

        flightService.createNew(flight);
        passengerSevice.createNew(passenger);

        passenger.getFlights().add(flight);

        passengerSevice.update(passenger);

        mainFrame.setContentPane(new MainForm().mainFormField);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }
}
