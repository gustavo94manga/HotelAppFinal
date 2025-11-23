package com.angel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angel.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long >{
	
    List<Payment> findByBooking_Customer_IdOrderByPaymentDateDesc(long customerId);
    List<Payment> findByPaymentStatus(String status);  // To find payments based on their status, e.g., "Completed", "Refunded"


}
