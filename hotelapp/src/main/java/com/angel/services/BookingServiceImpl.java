package com.angel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.angel.entities.Booking;
import com.angel.entities.Room;
import com.angel.exceptionhandling.ResourceNotFoundException;
import com.angel.repository.BookingRepository;
import com.angel.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{
	
	private final BookingRepository bookingRepository;
	private final RoomRepository roomRepository;

    @Override
    public List<Booking> getAllBookings() {
        try {
            return bookingRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching all bookings", e);
        }
    }

    @Override
    public Booking getBookingById(long id) {
        return bookingRepository.findById((long) id)
            .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
    }

    @Override
    public Booking createBooking(Booking booking) {
        try {
            // Additional business logic can be added here before saving
            return bookingRepository.saveAndFlush(booking);
        } catch (Exception e) {
            throw new RuntimeException("Error creating booking", e);
        }
    }

    @Override
    public Booking updateBooking(long id, Booking booking) {
        try {
            Booking existingBooking = bookingRepository.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));

            // Update fields of existingBooking with booking details
            existingBooking.setCheckInDate(booking.getCheckInDate());
            existingBooking.setCheckOutDate(booking.getCheckOutDate());
            //User should not be able to update the price of the hotel booking, only and Admin can.
//            existingBooking.setTotalPrice(booking.getTotalPrice());
            //User should not be able to change the booking status. The business logic already handles that. 
//            existingBooking.setBookingStatus(booking.getBookingStatus());
            // Update other fields as necessary

            return bookingRepository.saveAndFlush(existingBooking);
        } catch (ResourceNotFoundException e) {
            throw e;  // Rethrow ResourceNotFoundException for not found cases
        } catch (Exception e) {
            throw new RuntimeException("Error updating booking with id: " + id, e);
        }
    }

    @Override
    public String cancelBooking(long id) {
        try {
            Booking existingBooking = bookingRepository.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));

            existingBooking.setBookingStatus("CANCELLED");  // Update booking status to CANCELLED

            // Get the associated room and update its status
            Room associatedRoom = existingBooking.getRoom();
            associatedRoom.setStatus("AVAILABLE");

            // Save and flush the updated entities
            bookingRepository.saveAndFlush(existingBooking);
            roomRepository.saveAndFlush(associatedRoom);

            // Include the room number in the cancellation message
            return "Booking for room " + associatedRoom.getRoomNumber() + " was successfully cancelled.";
        } catch (ResourceNotFoundException e) {
            throw e;  // Rethrow ResourceNotFoundException for not found cases
        } catch (Exception e) {
            throw new RuntimeException("Error cancelling booking with id: " + id, e);
        }
    }

    @Override
    public List<Booking> getBookingsByUserEmail(String email) {
        try {
            return bookingRepository.findByCustomer_Email(email);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching bookings for email: " + email, e);
        }
    }

    @Override
    public Booking getBookingByIdAndHotelId(long id, long hotelId) {
        return bookingRepository.findByIdAndHotel_Id((long) id, (long) hotelId)
            .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id + " and hotelId: " + hotelId));
    }

}
