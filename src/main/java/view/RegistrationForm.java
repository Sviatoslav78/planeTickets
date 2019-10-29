package view;

import javax.swing.*;

public class RegistrationForm {
    private JTextField nameField;
    private JTextField passportIdField;
    private JTextField mailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JPanel signUpForm;
    private JButton registerButton;

    public JPanel getSignUpForm() {
        return signUpForm;
    }
}
