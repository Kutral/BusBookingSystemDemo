package com.teamproject.busbooking.ui;

import com.teamproject.busbooking.model.User;
import com.teamproject.busbooking.service.AuthService;
import com.teamproject.busbooking.service.BookingService;
import com.teamproject.busbooking.service.BusService;
import java.util.Scanner;

public class LoginMenu {
    private final AuthService authService;

    public LoginMenu(AuthService authService) {
        this.authService = authService;
    }

    public void displayRegister() {
        System.out.println("Register");

    }

    public void displayLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login");
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();

//        User user = authService.authenticate(username, password);
//
//        if (user != null) {
//            System.out.println("Login successful!");
//        }
    }
}
