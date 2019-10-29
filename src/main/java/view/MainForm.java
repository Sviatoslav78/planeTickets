package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JButton loginButton;
    private JButton registerButton;
    private JPanel mainFormField;

    private static JFrame frame = new JFrame("MainForm");

    public MainForm() {
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
        frame.setContentPane(new MainForm().mainFormField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
