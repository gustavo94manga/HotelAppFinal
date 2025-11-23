package com.angel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angel.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByCustomer_IdOrderByReviewDateDesc(Long customerId);  // Ensure the argument type is Long

    List<Review> findByHotel_Id(Long hotelId);  // Ensure the argument type is Long

    List<Review> findByCustomer_EmailOrderByReviewDateDesc(String email);
}
