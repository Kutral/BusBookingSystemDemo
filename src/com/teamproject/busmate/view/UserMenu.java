package com.teamproject.busmate.view;

import com.teamproject.busmate.model.User;
import com.teamproject.busmate.service.BookingService;
import com.teamproject.busmate.service.BusService;

import java.util.Scanner;

public class UserMenu {
    private final User currentUser;
    private final BusService busService;
    private final BookingService bookingService;


    public UserMenu(User currentUser, BusService busService, BookingService bookingService) {
        this.currentUser = currentUser;
        this.busService = busService;
        this.bookingService = bookingService;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nUser Menu");
            System.out.println("1. Book a Ticket");
            System.out.println("2. View My Bookings");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                     BookingService.bookTicket();
                    break;
                case 2:
                    // viewMyBookings();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return; // Exit the user menu and return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
