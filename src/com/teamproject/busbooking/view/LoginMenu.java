package com.teamproject.busbooking.view;

import com.teamproject.busbooking.model.User;
import com.teamproject.busbooking.service.AuthService;
import com.teamproject.busbooking.service.BookingService;
import com.teamproject.busbooking.service.BusService;

import java.util.Scanner;

public class LoginMenu {
    private final AuthService authService;
    private final BusService busService;
    private final BookingService bookingService;

    public LoginMenu(AuthService authService, BusService busService, BookingService bookingService) {
        this.authService = authService;
        this.busService = busService;
        this.bookingService = bookingService;
    }

    public void displayRegister() {
        System.out.println("You are in Register Menu : ");
        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        System.out.println("Enter email:");
        String email = scanner.next();


        User user = authService.register(username, password, email);
        if (user != null) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. Username might already exist.");
        }
    }


    public void displayLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in Login Menu :");
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();

        User user = authService.authenticate(username, password);

        if (user != null) {
            System.out.println("Login successful!");
            UserMenu userMenu = new UserMenu(user, busService, bookingService);
            userMenu.displayMenu();
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }
    }
}
