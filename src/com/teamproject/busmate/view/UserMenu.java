package com.teamproject.busmate.view;

import com.teamproject.busmate.Base.BaseView;
import com.teamproject.busmate.model.User;
import com.teamproject.busmate.service.BookingService;
import com.teamproject.busmate.service.BusService;

import java.util.Scanner;

public class UserMenu extends BaseView {
    private final User currentUser;
    private final BusService busService;
    private final BookingService bookingService;
    private final Scanner scanner;

    public UserMenu(Scanner scanner, User currentUser, BusService busService, BookingService bookingService) {
        this.currentUser = currentUser;
        this.busService = busService;
        this.bookingService = bookingService;
        this.scanner = scanner;
    }

    public void displayMenu() {
        while (true) {
            print("\nUser Menu");
            print("1. Book a Ticket");
            print("2. View My Bookings");
            print("3. Logout");
            print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                 //    BookingService.bookTicket();
                    break;
                case 2:
                    // viewMyBookings();
                    break;
                case 3:
                    print("Logging out...");
                    return;
                default:
                    print("Invalid choice. Please try again.");
            }
        }
    }
}
