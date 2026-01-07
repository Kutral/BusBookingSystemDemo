package com.teamproject.busmate.model;

import java.util.List;

public class Booking {
    private final String bookingId;
    private final String userId;
    private final String busId;
    private final List<Integer> seatNumbers;
    private final double totalPrice;
    private final long bookingDate;

    public Booking(String bookingId, String userId, String busId, List<Integer> seatNumbers, double totalPrice) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.busId = busId;
        this.seatNumbers = seatNumbers;
        this.totalPrice = totalPrice;
        this.bookingDate = System.currentTimeMillis();
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getBusId() {
        return busId;
    }

    public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public long getBookingDate() {
        return bookingDate;
    }
}
