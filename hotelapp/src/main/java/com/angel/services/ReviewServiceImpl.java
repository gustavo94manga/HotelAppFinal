package com.angel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.angel.entities.Review;
import com.angel.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();  // This will work if your findAll returns Iterable<Review>
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);  // Removed the intValue() call as id is already a Long
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        return reviewRepository.findById(id)  // Corrected findById to use Long directly
            .map(existingReview -> {
                existingReview.setRating(review.getRating());
                existingReview.setReview(review.getReview());
                existingReview.setReviewDate(review.getReviewDate());
                return reviewRepository.save(existingReview);
            }).orElse(null);
    }

    @Override
    public void deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
        }
    }

    @Override
    public List<Review> findReviewsByCustomerId(Long customerId) {
        return reviewRepository.findByCustomer_IdOrderByReviewDateDesc(customerId);
    }

    @Override
    public List<Review> findReviewsByHotelId(Long hotelId) {
        return reviewRepository.findByHotel_Id(hotelId);
    }

    @Override
    public List<Review> findReviewsByCustomerEmail(String email) {
        return reviewRepository.findByCustomer_EmailOrderByReviewDateDesc(email);
    }
}
