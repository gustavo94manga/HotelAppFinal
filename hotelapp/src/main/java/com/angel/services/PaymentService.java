package com.angel.services;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.angel.entities.Payment;

public interface PaymentService {
	   List<Payment> getAllPayments();
	    Payment getPaymentById(Long id);
	    Payment createPayment(Payment payment);
	    List<Payment> findPaymentsByCustomerId(Long customerId);
	    List<Payment> findPaymentsByStatus(String status);
	    
	    @PreAuthorize("hasRole('ADMIN')")  // Only users with the 'ROLE_ADMIN' can access this method
	    Payment processRefund(Long paymentId);
    
}
