package com.view;


import com.controller.AdminController;
import com.model.Route;
import com.service.AdminService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminForm {
    private JPanel mainAdminForm;
    private JComboBox departureBox;
    private JComboBox arrivalBox;
    private JComboBox planeBox;
    private JTextField timeField;
    private JButton chooseDateButton;
    private JButton addButton;

    private DateForm dateForm = new DateForm();
    private JFrame dateFrame = new JFrame("DateForm");

    private AdminService adminService = new AdminService();
    private AdminController adminController = new AdminController();

    public JFrame getDateFrame() {
        return dateFrame;
    }

    public JPanel getMainAdminForm() {
        return mainAdminForm;
    }

    public JComboBox<Route> getDepartureBox() {
        return departureBox;
    }

    public JComboBox getArrivalBox() {
        return arrivalBox;
    }

    public JComboBox getPlaneBox() {
        return planeBox;
    }

    public JTextField getTimeField() {
        return timeField;
    }

    public DateForm getDateForm() {
        return dateForm;
    }

    public AdminForm() {
        chooseDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dateFrame.setContentPane(dateForm.getMainDateFrom());
                dateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                dateFrame.pack();
                dateFrame.setVisible(true);

                dateFrame.add(dateForm.getDatePicker());
                dateFrame.setSize(250,70);
                dateFrame.setLocation(1063,568);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(timeField.getText() == "" || dateForm.getDatePicker().getModel() == null) {
                    JOptionPane.showMessageDialog(null, "Fill all fields!");
                } else if(adminService.flightIsValid(departureBox.getSelectedIndex(), arrivalBox.getSelectedIndex(), planeBox.getSelectedIndex(),
                        dateForm.getDatePicker().getModel(), timeField.getText())){
                    JOptionPane.showMessageDialog(null, "Ok");
                    adminController.createFight(departureBox.getSelectedIndex(), arrivalBox.getSelectedIndex(), planeBox.getSelectedIndex(),
                            dateForm.getDatePicker().getModel(), timeField.getText());
                }
            }
        });
    }
}
