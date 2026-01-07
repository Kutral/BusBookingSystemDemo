package com.teamproject.busmate.data;

import com.teamproject.busmate.model.Booking;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingRepository {
    private final List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookingsByUserId(String userId) {
        return bookings.stream()
                .filter(b -> b.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
