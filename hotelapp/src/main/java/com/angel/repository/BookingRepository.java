package com.angel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angel.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	Optional<Booking> findById(Long id); // Return Optional for better handling
	Optional<Booking> findByIdAndHotel_Id(Long id, Long hotelId); // Return Optional for better handling
	void deleteById(Long id);
	List<Booking> findByCustomer_Email(String email);
	List<Booking> findByCustomer_IdOrderByCreateDateDesc(long customerId);

}
