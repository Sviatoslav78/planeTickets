package com.view;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DateForm extends Container {
    private JPanel mainDateFrom;

    private UtilDateModel model = new UtilDateModel();
    private JDatePanelImpl datePanel = new JDatePanelImpl(model);
    private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

    public JPanel getMainDateFrom() {
        return mainDateFrom;
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

}
