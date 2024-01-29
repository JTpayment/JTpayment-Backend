package com.JTpayment.project.domain.payment.repository;

import com.JTpayment.project.domain.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
