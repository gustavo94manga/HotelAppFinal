package com.angel.services;

import java.util.List;
import java.util.Optional;

import com.angel.entities.Room;

public interface RoomService {
    List<Room> getRoomsByCustomerId(long customerId);
    
    Optional<Room> getRoomByIdAndBookingId(long roomId, long bookingId);
    
    Room getRoomByIdAndHotelId(long roomId, long hotelId);
    
    Room saveRoom(Room room);
    
    Room cancelRoomBooking(long roomId);  // This method cancels a room booking and updates the room's status
}
