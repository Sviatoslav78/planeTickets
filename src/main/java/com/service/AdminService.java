package com.service;

import com.model.Plane;
import com.model.Route;
import com.view.AdminForm;
import net.sourceforge.jdatepicker.DateModel;

import javax.swing.*;

public class AdminService {
    FlightService flightService;
    AdminForm adminForm;

    public boolean flightIsValid(int departureIndex, int arrivalIndex, int planeIndex, DateModel<?> date, String time) {
        boolean flag = true; // checks if flight is valid
        String[] exactTime = time.split(":");

        if(departureIndex == 0 || arrivalIndex == 0 || planeIndex == 0) {
            JOptionPane.showMessageDialog(null, "Fill all fields!");
            flag = false;
        } else if(departureIndex == arrivalIndex) {
            JOptionPane.showMessageDialog(null, "Departure and arrival must be different!");
            flag = false;
        } else if(!time.contains(":")) {
            JOptionPane.showMessageDialog(null, "Time must be in 00:00 format!");
            flag = false;
        } else if (Integer.parseInt(exactTime[0]) > 24 || Integer.parseInt(exactTime[0]) < 0 || Integer.parseInt(exactTime[1]) > 60 ||
                Integer.parseInt(exactTime[1]) < 0 || exactTime[0] == null || exactTime[1] == null) {
            JOptionPane.showMessageDialog(null, "Time must be in 00:00 format!");
            flag = false;
        }
        return flag;
    }
}
