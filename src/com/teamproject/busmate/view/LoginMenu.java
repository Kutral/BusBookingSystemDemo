package com.teamproject.busmate.view;

import com.teamproject.busmate.model.User;
import com.teamproject.busmate.service.AuthService;
import com.teamproject.busmate.service.BookingService;
import com.teamproject.busmate.service.BusService;

import java.util.Scanner;

public class LoginMenu {
    private final AuthService authService;
    private final BusService busService;
    private final BookingService bookingService;
    private final Scanner scanner = new Scanner(System.in);

    public LoginMenu(AuthService authService, BusService busService, BookingService bookingService) {
        this.authService = authService;
        this.busService = busService;
        this.bookingService = bookingService;
    }

    public void displayRegister() {
        System.out.println("You are in Register Menu : ");
        System.out.println("Enter username:");
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
        System.out.println("You are in Login Menu :");
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();

        User user = authService.authenticate(username, password);

        if (user != null) {
            System.out.println("Login successful!");
            // A simple way to check for admin role without modifying the User model yet.
            // For a real application, user.getRole().equals("ADMIN") would be better.
            if ("admin".equalsIgnoreCase(user.getUsername())) {
                AdminMenu adminMenu = new AdminMenu(scanner, busService);
                adminMenu.displayMenu();
            } else {
                UserMenu userMenu = new UserMenu(user, busService, bookingService);
                userMenu.displayMenu();
            }
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }
    }
}
