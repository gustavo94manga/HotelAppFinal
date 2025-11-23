package com.angel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angel.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findByBookings_Customer_Email(String email);  // Querying via Bookings
    void deleteById(Long hotelId);
    List<Hotel> findByBookings_Customer_IdOrderByCreateDateDesc(long customerId);
	List<Hotel> findByCity(String city);
	List<Hotel> findByState(String state);
	
}
