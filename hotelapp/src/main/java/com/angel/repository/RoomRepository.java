package com.angel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angel.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
	
	List<Room> findByBookings_Customer_Id(long customerId);
	Optional<Room> findByIdAndBookings_Id(long roomId, long bookingId);
	Room findByIdAndHotel_Id(long roomId, long hotelId);

}
