package com.teamproject.busbooking.view;

import com.teamproject.busbooking.model.User;
import com.teamproject.busbooking.service.BookingService;
import com.teamproject.busbooking.service.BusService;

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
            System.out.println("1. View All Buses");
            System.out.println("2. Book a Ticket");
            System.out.println("3. View My Bookings");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // viewAllBuses();
                    break;
                case 2:
                    // bookTicket();
                    break;
                case 3:
                    // viewMyBookings();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return; // Exit the user menu and return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
