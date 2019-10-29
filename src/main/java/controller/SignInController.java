package controller;


import model.AccountStatus;

public class SignInController {

    public AccountStatus login(String login, String password) {
        if (login.equals("admin") || password.equals("admin")) {
            return AccountStatus.ADMIN;
        } else if (login.equals("user") || password.equals("user")) {
            return AccountStatus.USER;
        } else {
            return AccountStatus.NOT_DEFINED;
        }

    }
}
