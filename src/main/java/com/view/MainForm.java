package com.view;


import com.service.FlightPassengerService;
import com.service.FlightService;
import com.service.PassengerSevice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainForm {
    private JButton loginButton;
    private JButton registerButton;
    private JPanel mainFormField;

    private static JFrame mainFrame = new JFrame("MainForm");
    private static JFrame signInFrame = new JFrame("SignInForm");
    private static JFrame signUpFrame = new JFrame("RegistrationForm");

    private static FlightService flightService = new FlightService();
    private static PassengerSevice passengerSevice = new PassengerSevice();
    private static FlightPassengerService flightPassengerService = new FlightPassengerService();

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
                signInFrame.setLocation(768,420);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                signUpFrame.setContentPane(new RegistrationForm().getSignUpForm());
                signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                signUpFrame.pack();
                signUpFrame.setVisible(true);
                mainFrame.setVisible(false);
                signUpFrame.setLocation(768,420);
            }
        });
    }

    public static void main(String[] args) {
//        HibernateFactory.HIBERNATE_FACTORY.getSessionFactory().openSession();

//        Flight flight = new Flight(Route.BERLIN.getName(), Route.KYIV.getName(), new GregorianCalendar(2019, Calendar.NOVEMBER, 17, 16,17), Plane.Boeing.getName(), new ArrayList<Passenger>());
//        Flight flight1 = new Flight(Route.MOSCOW.getName(), Route.BERLIN.getName(), new GregorianCalendar(2019, Calendar.DECEMBER, 17, 16,17), Plane.Boeing.getName(), new ArrayList<Passenger>());
//        Passenger passenger = new Passenger("Svyat", "user", "user", new ArrayList<Flight>());
//        passengerSevice.createNew(passenger);

//        flightService.createNew(flight);
//        flightService.createNew(flight1);


        mainFrame.setContentPane(new MainForm().mainFormField);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setLocation(768,420);
    }
}
