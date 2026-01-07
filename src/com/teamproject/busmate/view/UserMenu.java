package com.teamproject.busmate.view;

import com.teamproject.busmate.Base.BaseView;
import com.teamproject.busmate.model.Booking;
import com.teamproject.busmate.model.Bus;
import com.teamproject.busmate.model.Seat;
import com.teamproject.busmate.model.User;
import com.teamproject.busmate.service.BookingService;
import com.teamproject.busmate.service.BusService;
import com.teamproject.busmate.Constants.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            printAll(constants.UserMenu);

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    viewMyBookings();
                    break;
                case 3:
                    print("Logging out...");
                    return;
                default:
                    print("Invalid choice. Please try again.");
            }
        }
    }

    private void bookTicket() {
        print("-----------------------------------------");
        print("Book Ticket");
        String from = printQuestion("Enter From Location: ", scanner);
        String to = printQuestion("Enter To Location: ", scanner);

        List<Bus> buses = busService.searchBus(from, to);
        if (buses.isEmpty()) {
            print("No buses found for this route.");
            return;
        }

        print("Available Buses:");
        for (Bus bus : buses) {
            print("ID: " + bus.getBusId() + " | Name: " + bus.getBusName() + " | Price: " + bus.getPrice() + " | Available Seats: " +
                    bus.getSeats().stream().filter(s -> !s.isBooked()).count());
        }

        String busId = printQuestion("Enter Bus ID to book: ", scanner);
        Bus selectedBus = busService.searchBus(busId);

        if (selectedBus == null || !selectedBus.getBusFrom().equalsIgnoreCase(from) || !selectedBus.getBusTo().equalsIgnoreCase(to)) {
            print("Invalid Bus ID selected.");
            return;
        }

        print("Seat Layout ( [X] Booked, [O] Available ):");
        int count = 0;
        for (Seat seat : selectedBus.getSeats()) {
            if (seat.isBooked()) {
                System.out.print("[X] " + seat.getSeatNumber() + "\t");
            } else {
                System.out.print("[O] " + seat.getSeatNumber() + "\t");
            }
            count++;
            if (count % 4 == 0) System.out.println();
        }
        System.out.println();

        print("Enter seat numbers to book (comma separated, e.g., 1,2): ");
        String seatsStr = scanner.nextLine();
        String[] seatTokens = seatsStr.split(",");
        List<Integer> seatNumbers = new ArrayList<>();
        try {
            for (String token : seatTokens) {
                seatNumbers.add(Integer.parseInt(token.trim()));
            }
        } catch (NumberFormatException e) {
            print("Invalid seat number format.");
            return;
        }

        try {
            Booking booking = bookingService.createBooking(currentUser, selectedBus, seatNumbers);
            print("Booking Successful!");
            print("Booking ID: " + booking.getBookingId());
            print("Total Price: " + booking.getTotalPrice());
        } catch (Exception e) {
            print("Booking Failed: " + e.getMessage());
        }
    }

    private void viewMyBookings() {
        print("-----------------------------------------");
        print("My Bookings");
        List<Booking> bookings = bookingService.getUserBookings(currentUser);
        if (bookings.isEmpty()) {
            print("No bookings found.");
        } else {
            for (Booking booking : bookings) {
                Bus bus = busService.searchBus(booking.getBusId());
                String busName = (bus != null) ? bus.getBusName() : "Unknown Bus";
                String route = (bus != null) ? bus.getBusFrom() + " -> " + bus.getBusTo() : "Unknown Route";
                
                print("Booking ID: " + booking.getBookingId());
                print("Bus: " + busName + " (" + route + ")");
                print("Seats: " + booking.getSeatNumbers());
                print("Total Price: " + booking.getTotalPrice());
                print("-----------------------------------------");
            }
        }
    }
}
