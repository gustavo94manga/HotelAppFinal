package com.angel.services;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.angel.entities.Payment;
import com.angel.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

	  private final PaymentRepository paymentRepository;

	    @Override
	    public List<Payment> getAllPayments() {
	        return paymentRepository.findAll();
	    }

	    @Override
	    public Payment getPaymentById(Long id) {
	        return paymentRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Payment createPayment(Payment payment) {
	        return paymentRepository.save(payment);
	    }

	    @Override
	    public List<Payment> findPaymentsByCustomerId(Long customerId) {
	        return paymentRepository.findByBooking_Customer_IdOrderByPaymentDateDesc(customerId);
	    }

	    @Override
	    public List<Payment> findPaymentsByStatus(String status) {
	        return paymentRepository.findByPaymentStatus(status);
	    }

	    @Override
	    @PreAuthorize("hasRole('ADMIN')")  // Automatically checks for ROLE_ADMIN
	    public Payment processRefund(Long paymentId) {
	        Payment payment = paymentRepository.findById(paymentId).orElse(null);
	        if (payment != null && "Completed".equals(payment.getPaymentStatus())) {
	            payment.setPaymentStatus("Refunded");
	            return paymentRepository.save(payment);
	        }
	        return null;
	    }

}
