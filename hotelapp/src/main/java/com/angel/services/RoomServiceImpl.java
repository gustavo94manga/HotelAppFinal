package com.angel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.angel.entities.Room;
import com.angel.exceptionhandling.ResourceNotFoundException;
import com.angel.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public List<Room> getRoomsByCustomerId(long customerId) {
        return roomRepository.findByBookings_Customer_Id(customerId);
    }

    @Override
    public Optional<Room> getRoomByIdAndBookingId(long roomId, long bookingId) {
        return roomRepository.findByIdAndBookings_Id(roomId, bookingId);
    }

    @Override
    public Room getRoomByIdAndHotelId(long roomId, long hotelId) {
        return roomRepository.findByIdAndHotel_Id(roomId, hotelId);
    }

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room cancelRoomBooking(long roomId) {
        Room existingRoom = roomRepository.findById(roomId)
            .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + roomId));
        
        existingRoom.setStatus("CANCELLED");
        
        return roomRepository.save(existingRoom);
    }
}
