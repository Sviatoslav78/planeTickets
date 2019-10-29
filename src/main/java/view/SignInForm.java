package view;

import controller.SignInController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInForm {
    private JPanel signInForm;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton signInButton;

    private SignInController signInController = new SignInController();

    public JPanel getSignInForm() {
        return signInForm;
    }

    public SignInForm() {
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
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
    }

}
