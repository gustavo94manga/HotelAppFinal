package com.angel.services;

import java.util.List;
import com.angel.entities.Booking;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(long id);
    Booking createBooking(Booking booking);
    Booking updateBooking(long id, Booking booking);
    String cancelBooking(long id);  // This method cancels a booking and returns a confirmation message with the room number
    List<Booking> getBookingsByUserEmail(String email);
    Booking getBookingByIdAndHotelId(long id, long hotelId);
}
