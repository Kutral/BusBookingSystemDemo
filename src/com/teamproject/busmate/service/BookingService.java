package com.teamproject.busmate.service;

import com.teamproject.busmate.data.BookingRepository;
import com.teamproject.busmate.model.Booking;
import com.teamproject.busmate.model.Bus;
import com.teamproject.busmate.model.Seat;
import com.teamproject.busmate.model.User;

import java.util.List;
import java.util.UUID;

public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService() {
        this.bookingRepository = BookingRepository.getInstance();
    }

    public Booking createBooking(User user, Bus bus, List<Integer> seatNumbers) {
        // Validate seats
        for (Integer seatNum : seatNumbers) {
            if (seatNum < 1 || seatNum > bus.getCapacity()) {
                throw new IllegalArgumentException("Invalid seat number: " + seatNum);
            }
            Seat seat = bus.getSeats().get(seatNum - 1);
            if (seat.isBooked()) {
                throw new IllegalStateException("Seat " + seatNum + " is already booked.");
            }
        }

        // Book seats
        for (Integer seatNum : seatNumbers) {
            bus.getSeats().get(seatNum - 1).setBooked(true);
        }

        double totalPrice = seatNumbers.size() * bus.getPrice();
        Booking booking = new Booking(UUID.randomUUID().toString(), user.getUserId(), bus.getBusId(), seatNumbers, totalPrice);
        bookingRepository.addBooking(booking);
        return booking;
    }

    public List<Booking> getUserBookings(User user) {
        return bookingRepository.getBookingsByUserId(user.getUserId());
    }
}
