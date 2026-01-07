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
        printAll(constants.RegisterMenu);
        String username = scanner.next();
        String password = scanner.next();
        String email = scanner.next();

        com.teamproject.busmate.service.ValidationService validationService = new com.teamproject.busmate.service.ValidationService();
        if (!validationService.isValidEmail(email)) {
            print("Invalid email format.");
            return;
        }
        if (!validationService.isValidPassword(password)) {
            print("Password must be at least 6 characters long.");
            return;
        }

        User user = authService.register(username, password, email);
        if (user != null) {
            print("Registration successful!");
        } else {
            print("Registration failed. Username might already exist.");
        }

    }

    public void displayLogin() {
        printAll(constants.LoginMenu);
        String username = scanner.next();
        String password = scanner.next();
        User user = authService.authenticate(username, password);

        if (user != null) {
            print("Login successful!");

            if ("ADMIN".equalsIgnoreCase(user.getUserType())) {
                
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
