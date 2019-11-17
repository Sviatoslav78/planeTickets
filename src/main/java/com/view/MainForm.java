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
import java.util.List;

public class MainForm {
    private JButton loginButton;
    private JButton registerButton;
    private JPanel mainFormField;

    private static JFrame frame = new JFrame("MainForm");
    private static FlightService flightService = new FlightService();
    private static PassengerSevice passengerSevice = new PassengerSevice();

    public MainForm() {
        HibernateFactory.HIBERNATE_FACTORY.getSessionFactory().openSession();
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame("SignInForm");
                frame1.setContentPane(new SignInForm().getSignInForm());
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.pack();
                frame1.setVisible(true);
                frame.setVisible(false);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame2 = new JFrame("RegistrationForm");
                frame2.setContentPane(new RegistrationForm().getSignUpForm());
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setVisible(true);
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        Flight flight = new Flight(Route.MOSCOW.getName(), Route.LONDON.getName(), new GregorianCalendar(2019, Calendar.NOVEMBER, 17, 16,17), Plane.Boeing.getName(), new ArrayList<Passenger>());
        Passenger passenger = new Passenger("Sviatoslav", 1000, new ArrayList<Flight>());

        flightService.createNew(flight);
        passengerSevice.createNew(passenger);

        passenger.getFlights().add(flight);

        passengerSevice.update(passenger);


        frame.setContentPane(new MainForm().mainFormField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
