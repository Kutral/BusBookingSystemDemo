package com.teamproject.busmate.view;

import com.teamproject.busmate.Base.BaseView;
import com.teamproject.busmate.Constants.constants;
import com.teamproject.busmate.model.User;
import com.teamproject.busmate.service.AuthService;
import com.teamproject.busmate.service.BookingService;
import com.teamproject.busmate.service.BusService;

import java.util.Scanner;

public class LoginMenu extends BaseView {
    private final AuthService authService;
    private final BusService busService;
    private final BookingService bookingService;
    private final Scanner scanner;

    public LoginMenu(Scanner scanner, AuthService authService, BusService busService, BookingService bookingService) {
        this.authService = authService;
        this.busService = busService;
        this.bookingService = bookingService;
        this.scanner = scanner;
    }

    public void displayRegister() {
        print("-----------------------------------------");
        print("You are in Register Menu : ");
        print("Enter username:");
        String username = scanner.next();
        print("Enter password:");
        String password = scanner.next();
        print("Enter email:");
        String email = scanner.next();
        print("-----------------------------------------");


        User user = authService.register(username, password, email);
        if (user != null) {
            print("Registration successful!");
        } else {
            print("Registration failed. Username might already exist.");
        }

    }

    public void displayLogin() {
        print("-----------------------------------------");
        print("You are in Login Menu :");
        print("Enter username: ");
        String username = scanner.next();
        print("Enter password: ");
        String password = scanner.next();
        print("-----------------------------------------");
        User user = authService.authenticate(username, password);

        if (user != null) {
            print("Login successful!");

            if ("admin".equalsIgnoreCase(user.getUsername())) {
                
                AdminMenu adminMenu = new AdminMenu(scanner, busService); // Already correct
                adminMenu.displayMenu();
            } else {
                UserMenu userMenu = new UserMenu(scanner, user, busService, bookingService);
                userMenu.displayMenu();
            }
        } else {
            print("Login failed. Please check your username and password.");
        }
    }
}
