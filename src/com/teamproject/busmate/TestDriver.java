package com.teamproject.busmate;

import com.teamproject.busmate.data.UserRepository;
import com.teamproject.busmate.model.Booking;
import com.teamproject.busmate.model.Bus;
import com.teamproject.busmate.model.User;
import com.teamproject.busmate.service.AuthService;
import com.teamproject.busmate.service.BookingService;
import com.teamproject.busmate.service.BusService;

import java.util.Arrays;
import java.util.List;

public class TestDriver {
    public static void main(String[] args) {
        System.out.println("Starting Test Driver...");

        // Setup Services
        UserRepository userRepository = UserRepository.getInstance();
        AuthService authService = new AuthService(userRepository);
        BusService busService = new BusService();
        BookingService bookingService = new BookingService();

        // 1. Test Admin Add Bus
        System.out.println("\n--- Test 1: Admin Add Bus ---");
        Bus bus = busService.addBus("B001", "TN-01-1234", "Sleeper", "Chennai Express", "Chennai", "Bangalore", 10, 500.0);
        if (bus != null && busService.viewAllBuses().size() >= 1) {
            System.out.println("PASS: Bus added.");
        } else {
            System.out.println("FAIL: Bus not added.");
        }

        // 2. Test User Registration
        System.out.println("\n--- Test 2: User Registration ---");
        // Using unique username to avoid conflict with existing runs if persistence was real (though here it's in-memory)
        String testUser = "testuser_" + System.currentTimeMillis();
        User newUser = authService.register(testUser, "pass123", "test@example.com");
        if (newUser != null) {
            System.out.println("PASS: User registered.");
        } else {
            System.out.println("FAIL: User registration failed.");
        }

        // 3. Test Login
        System.out.println("\n--- Test 3: User Login ---");
        User loggedInUser = authService.authenticate(testUser, "pass123");
        if (loggedInUser != null) {
            System.out.println("PASS: Login successful.");
        } else {
            System.out.println("FAIL: Login failed.");
        }

        // 4. Test Search Bus
        System.out.println("\n--- Test 4: Search Bus ---");
        List<Bus> searchResults = busService.searchBus("Chennai", "Bangalore");
        if (!searchResults.isEmpty()) {
            System.out.println("PASS: Bus found.");
        } else {
            System.out.println("FAIL: Bus search failed.");
        }

        // 5. Test Book Ticket
        System.out.println("\n--- Test 5: Book Ticket ---");
        try {
            Bus targetBus = searchResults.get(0);
            List<Integer> seatsToBook = Arrays.asList(1, 2);
            Booking booking = bookingService.createBooking(loggedInUser, targetBus, seatsToBook);
            if (booking != null && booking.getSeatNumbers().contains(1)) {
                System.out.println("PASS: Booking successful. ID: " + booking.getBookingId());
            } else {
                System.out.println("FAIL: Booking creation returned null.");
            }
        } catch (Exception e) {
            System.out.println("FAIL: Exception during booking: " + e.getMessage());
        }

        // 6. Test View Bookings
        System.out.println("\n--- Test 6: View Bookings ---");
        List<Booking> userBookings = bookingService.getUserBookings(loggedInUser);
        if (userBookings.size() == 1) {
            System.out.println("PASS: Booking found for user.");
        } else {
            System.out.println("FAIL: Booking count incorrect. Expected 1, got " + userBookings.size());
        }

        // 7. Test Seat Availability (Double Booking)
        System.out.println("\n--- Test 7: Double Booking Prevention ---");
        try {
            List<Integer> seatsToBookAgain = Arrays.asList(1); // Seat 1 is already booked
            bookingService.createBooking(loggedInUser, bus, seatsToBookAgain);
            System.out.println("FAIL: Should have thrown exception for already booked seat.");
        } catch (IllegalStateException e) {
            System.out.println("PASS: Caught expected exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("FAIL: Caught unexpected exception: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\nTests Completed.");
    }
}
