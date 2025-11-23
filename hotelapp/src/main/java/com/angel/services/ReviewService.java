package com.angel.services;

import java.util.List;

import com.angel.entities.Review;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(Long id);
    Review createReview(Review review);
    Review updateReview(Long id, Review review);
    void deleteReview(Long id);
    List<Review> findReviewsByCustomerId(Long customerId);
    List<Review> findReviewsByHotelId(Long hotelId);
    List<Review> findReviewsByCustomerEmail(String email);
}